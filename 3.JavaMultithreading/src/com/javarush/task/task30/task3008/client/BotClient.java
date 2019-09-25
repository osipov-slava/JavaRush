package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    public class BotSocketThread extends SocketThread{

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();


//            2. Переопредели метод processIncomingMessage(String message).
//                    Он должен следующим образом обрабатывать входящие сообщения:
//            а) Вывести в консоль текст полученного сообщения message.
//                    б) Получить из message имя отправителя и текст сообщения. Они разделены ": ".
//                    в) Отправить ответ в зависимости от текста принятого сообщения.
//            Если текст сообщения:
//            "дата" - отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
//            "день" - в формате "d";
//            "месяц" - "MMMM";
//            "год" - "YYYY";
//            "время" - "H:mm:ss";
//            "час" - "H";
//            "минуты" - "m";
//            "секунды" - "s".
//                    Указанный выше формат используй для создания объекта SimpleDateFormat.
// Для получения текущей даты необходимо использовать класс Calendar и метод getTime().
//                    Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ,
// например, если Боб отправил запрос "время", мы должны отправить ответ "Информация для Боб: 12:30:47".
//
//                    Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись,
// что все работает правильно.
//                    Помни, что message бывают разных типов и не всегда содержат ":"
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (!message.contains(": ")) return;
            String[] args = message.split(": ");
            if (args.length != 2) return; // выйти, если формат сообщения не  имя : сообщение
            String senderName = args[0];
            String senderMessage = args[1];
            String dateFormat = "";
            switch (senderMessage){
                case "дата" : {
                    dateFormat = "d.MM.YYYY";
                    break;
                }
                case "день" : {
                    dateFormat = "d";
                    break;
                }
                case "месяц" : {
                    dateFormat = "MMMM";
                    break;
                }
                case "год" : {
                    dateFormat = "YYYY";
                    break;
                }
                case "время" : {
                    dateFormat = "H:mm:ss";
                    break;
                }
                case "час" : {
                    dateFormat = "H";
                    break;
                }
                case "минуты" : {
                    dateFormat = "m";
                    break;
                }
                case "секунды" : {
                    dateFormat = "s";
                    break;
                }
                default: return;
            }
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            Calendar calendar = Calendar.getInstance();
            sendTextMessage("Информация для "+ senderName + ": " + formatter.format(calendar.getTime()));
        }
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }
}
