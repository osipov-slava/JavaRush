package com.javarush.task.task40.testSendEmail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


public class Test {
    public static void main(String[] args) throws IOException{
        Properties props = new Properties();
        props.load(Test.class.getClassLoader().getResourceAsStream("mailru.properties"));

        Session session;
        {
            session = Session.getDefaultInstance(props);
        }

        try {
            //создаем сообщение
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("skybright@mail.ru"));
//указываем получателя
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("osipov1199@yandex.ru"));
//устанавливаем тему письма
            message.setSubject("тестовое письмо!");
//добавляем текст письма
            message.setText("Asta la vista, baby!");
//указываем дату отправления
            message.setSentDate(new Date());

//авторизуемся на сервере:
            Transport transport = session.getTransport();
            transport.connect(props.getProperty("mail.user"), props.getProperty("mail.password"));

//отправляем сообщение:
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
