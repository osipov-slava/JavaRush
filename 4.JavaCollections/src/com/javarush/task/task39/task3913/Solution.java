package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

import static com.javarush.task.task39.task3913.Event.SOLVE_TASK;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("G:\\OneDriveCopy\\OneDrive\\Программирование\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs"));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
//        System.out.println(logParser.getUniqueIPs(null, null));
//        System.out.println(logParser.getIPsForUser("Amigo",null, new Date()));
//        System.out.println(logParser.getIPsForEvent(SOLVE_TASK,null, null));
//        System.out.println(logParser.getIPsForStatus(Status.FAILED,null, null));
//        System.out.println(logParser.getAllUsers());
//        System.out.println(logParser.getNumberOfUsers(null, null));
//        System.out.println(logParser.getNumberOfUserEvents("Amigo",null, null));
//        System.out.println(logParser.getUsersForIP("127.0.0.1",null, null));
//        System.out.println(logParser.getLoggedUsers(null, null));
//        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null, null));
//        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null, null));
//        System.out.println(logParser.execute("get ip"));
//        System.out.println(logParser.execute("get ip for user = \"Vasya Pupkin\""));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"."));
        System.out.println(logParser.execute("get event for date = \"03.01.2014 03:45:23\""));
    }
}