package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;
import static com.javarush.task.task26.task2613.ConsoleHelper.*;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        String code = askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        Map<Integer, Integer> listBanknotes = new TreeMap<>();

        int withdraw = 0;
        writeMessage(res.getString("before"));
        do {
            try {
                withdraw = Integer.parseInt(readString());
            } catch (NumberFormatException e) {
                writeMessage(res.getString("specify.amount"));
                continue;
            }
            if (withdraw < 0) {
                writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (!manipulator.isAmountAvailable(withdraw)) {
                writeMessage(res.getString("not.enough.money"));
                continue;
            }
            try {
                listBanknotes = manipulator.withdrawAmount(withdraw);
                break;
            } catch (NotEnoughMoneyException e) {
                writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
        } while (true);

        for (Map.Entry<Integer, Integer> entry : listBanknotes.entrySet()) {
            writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
        }
        writeMessage(String.format(res.getString("success.format"), withdraw, code));
    }
}
