package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;
import static com.javarush.task.task26.task2613.ConsoleHelper.writeMessage;

class InfoCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "info_en");

    @Override
    public void execute() {
        CurrencyManipulatorFactory factory = CurrencyManipulatorFactory.getInstance();
        boolean isEmpty = true;
        writeMessage(res.getString("before"));
        for (CurrencyManipulator manipulator: factory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                System.out.println(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
                isEmpty = false;
            }
        }
        if (isEmpty) writeMessage(res.getString("no.money"));
    }
}
