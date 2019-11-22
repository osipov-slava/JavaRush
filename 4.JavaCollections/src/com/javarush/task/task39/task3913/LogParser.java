package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.QLQuery;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LogParser implements QLQuery {
    Path logDir;
    List<StringLog> stringLogs;

    public LogParser(Path logDir) {
        this.logDir = logDir;
        List<File> files = getLogFiles();
        List<String> strings = readStringsFromFiles(files);
        stringLogs = parcingStringLogs(strings);
    }

    private List<File> getLogFiles() {
        File[] files = logDir.toFile().listFiles();
        List<File> logFiles = new ArrayList<>();
        for (File f : files) {
            if (f.getName().endsWith(".log")) logFiles.add(f);
        }
        return logFiles;
    }

    private List<String> readStringsFromFiles(List<File> files) {
        List<String> stringsFromFiles = new ArrayList<>();
        for (File f : files) {
            try {
                List<String> strings = Files.lines(Paths.get(f.getAbsolutePath()))
                        .collect(Collectors.toList());
                stringsFromFiles.addAll(strings);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringsFromFiles;
    }

    private List<StringLog> parcingStringLogs(List<String> strings) {
        List<StringLog> list = new ArrayList<>();
        for (String s : strings) {
            String[] parameters = s.split("\t");
            StringLog stringLog = new StringLog();
            stringLog.ip = parameters[0];
            stringLog.user = parameters[1];
            stringLog.date = parcingDate(parameters[2]);
            String[] eventANDtask = parameters[3].split(" ");
            stringLog.event = Event.valueOf(eventANDtask[0]);
            // эвент можеть быть с таском!
            if (eventANDtask.length > 1)
                stringLog.task = Integer.parseInt(eventANDtask[1]);
            stringLog.status = Status.valueOf(parameters[4]);
            list.add(stringLog);
        }
        return list;
    }

    private Date parcingDate(String stringDate) {
        Date date = new Date();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.applyPattern("dd.MM.y HH:mm:ss");
            date = simpleDateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private List<StringLog> filterByDate(Date after, Date before) {
        if (after == null && before == null) {
            return stringLogs;
        }
        List<StringLog> filteredList = new ArrayList<>();
        for (StringLog stringLog : stringLogs) {
            if (after == null && before != null) {
                if (stringLog.date.compareTo(before) < 0)
                    filteredList.add(stringLog);
            } else if (after != null && before == null) {
                if (stringLog.date.compareTo(after) > 0)
                    filteredList.add(stringLog);
            } else {
                if (stringLog.date.compareTo(before) < 0
                        && stringLog.date.compareTo(after) > 0)
                    filteredList.add(stringLog);
            }
        }
        return filteredList;
    }

    @Override
    public Set<Object> execute(String query) {
        String[] strings = query.split(" ");
        String field1 = strings[1];
        Set<Object> set = stringLogs.stream()
                .map(m -> m.getField(field1))
                .collect(Collectors.toSet());
        if (strings.length == 2) return set;

        String field2 = strings[3];
        int start = query.indexOf("\"") + 1;
        int end = query.indexOf("\"", start);
        String value = query.substring(start, end);
        Object objectValue = convertStringToObject(field2, value);
        if (query.length() == end + 1) return stringLogs.stream()
                .filter(f -> f.getField(field2).equals(objectValue))
                .map(m -> m.getField(field1))
                .collect(Collectors.toSet());

        start = query.indexOf("\"", end + 1) + 1;
        end = query.indexOf("\"", start);
        String afterString = query.substring(start, end);
        start = query.indexOf("\"", end + 1) + 1;
        end = query.indexOf("\"", start);
        String beforeString = query.substring(start, end);
        Date after = parcingDate(afterString);
        Date before = parcingDate(beforeString);
        return filterByDate(after, before).stream()
                .filter(f -> f.getField(field2).equals(objectValue))
                .map(m -> m.getField(field1))
                .collect(Collectors.toSet());
    }

    private Object convertStringToObject(String field2, String value) {
        switch (field2) {
            case "ip"   : return value;
            case "user" : return value;
            case "date" : return parcingDate(value);
            case "event": return Event.valueOf(value);
            case "status": return Status.valueOf(value);
            default     : return null;
        }
    }

    private class StringLog {
        String ip;
        String user;
        Date date;
        Event event;
        Integer task;
        Status status;

        private Object getField(String field) {
            switch (field) {
                case "ip"   : return ip;
                case "user" : return user;
                case "date" : return date;
                case "event": return event;
                case "status": return status;
                default     : return null;
            }
        }
    }
}