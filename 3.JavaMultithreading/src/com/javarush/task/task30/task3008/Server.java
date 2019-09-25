package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.javarush.task.task30.task3008.MessageType.*;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args){

        int port = ConsoleHelper.readInt();
        try {
            ServerSocket serverSocket;
            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Сервер запущен...");
            Socket socket = null;
            try {
                while (true){
                    socket = serverSocket.accept();
                    Handler handler = new Handler(socket);
                    handler.start();
                }
            } catch (IOException e) {
                socket.close();
                System.out.println(e);
            } finally {
                serverSocket.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    private static class Handler extends Thread{
        Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run(){

            ConsoleHelper.writeMessage("Установлено соединение с " + socket.getRemoteSocketAddress());

            try (Connection connection = new Connection(socket)) {
                    String newUser = serverHandshake(connection);
                    sendBroadcastMessage(new Message(USER_ADDED, newUser));
                    notifyUsers(connection, newUser);
                    serverMainLoop(connection, newUser);
                    ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
                    connectionMap.remove(newUser);
                    sendBroadcastMessage(new Message(USER_REMOVED, newUser));

                } catch (IOException | ClassNotFoundException e) {
                    ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");

                }



        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            Message clientMessage;
            do {
                connection.send(new Message(NAME_REQUEST,"Введите имя пользователя:"));
                clientMessage = connection.receive();
                if (clientMessage.getType() != USER_NAME ||
                        connectionMap.containsKey(clientMessage.getData()) ||
                        clientMessage.getData().equals("")) continue;
                break;
            } while (true);

            connectionMap.put(clientMessage.getData(),connection);
            connection.send(new Message(NAME_ACCEPTED,"Ваше имя принято."));
            return clientMessage.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String, Connection> pair: connectionMap.entrySet()){
                if (!pair.getKey().equals(userName))
                    connection.send(new Message(USER_ADDED, pair.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            Message clientMessage;
            while (true) {
                clientMessage = connection.receive();
                if (clientMessage.getType() == MessageType.TEXT) {
                    if (clientMessage.getData().equals("exit")) break;
                    Message newMessage = new Message(TEXT, userName + ": " + clientMessage.getData());
                    sendBroadcastMessage(newMessage);
                }
                else ConsoleHelper.writeMessage("Сообщение не является текстом!");
            }
        }
    }

    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String, Connection> pair: connectionMap.entrySet()) {
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Сообщение не было отправлено");
            }

        }
    }
}
