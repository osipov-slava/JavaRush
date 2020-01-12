package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;
import static com.javarush.task.task26.task2613.ConsoleHelper.readString;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        String userCard;
        String userPIN;
        writeMessage(res.getString("before"));

        do {
            do {
                writeMessage(res.getString("specify.data"));
                userCard = readString();
                if (userCard.matches("\\d{12}")) break;
                writeMessage(res.getString("try.again.or.exit"));
                writeMessage(res.getString("try.again.with.details"));
            } while (true);

            do {
                userPIN = readString();
                if (userPIN.matches("\\d{4}")) break;
                writeMessage(res.getString("try.again.or.exit"));
                writeMessage(res.getString("try.again.with.details"));
            } while (true);
            if (validCreditCards.containsKey(userCard) && validCreditCards.getString(userCard).equals(userPIN)) {
                writeMessage(String.format(res.getString("success.format"), userCard));
                break;
            }
            writeMessage(String.format(res.getString("not.verified.format"), userCard));

        } while (true);
    }
}
