package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;
import static com.javarush.task.task26.task2613.ConsoleHelper.*;

class DepositCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
        CurrencyManipulatorFactory factory = CurrencyManipulatorFactory.getInstance();
        writeMessage(res.getString("before"));
        String code = askCurrencyCode();
        CurrencyManipulator manipulator = factory.getManipulatorByCurrencyCode(code);

        String[] two = getValidTwoDigits(code);
        manipulator.addAmount(Integer.parseInt(two[0]),Integer.parseInt(two[1]));
        writeMessage(String.format(res.getString("success.format"), Integer.parseInt(two[0]) * Integer.parseInt(two[1]), code));
    }
}
