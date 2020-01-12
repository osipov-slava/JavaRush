package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;
import static com.javarush.task.task26.task2613.ConsoleHelper.*;

class ExitCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "exit_en");

    @Override
    public void execute() throws InterruptOperationException {
        writeMessage(res.getString("exit.question.y.n"));
        String s = "";
        do {
            s = readString();
            if (s.equals("y")) {
                writeMessage(res.getString("thank.message"));
                return;
            } else if (s.equals("n")) return;
        } while (true);
    }
}
