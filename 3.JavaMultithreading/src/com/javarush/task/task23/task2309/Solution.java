package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
*/
public class Solution {

    public List<User> getUsers(){
        AbstractDbSelectExecutor<User> user = new AbstractDbSelectExecutor<User>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }

            @Override
            public List<User> execute() {
                return super.execute();
            }
        };
       return user.execute();
    }

    public List<Location> getLocations(){
        AbstractDbSelectExecutor<Location> location = new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }

            @Override
            public List execute() {
                return super.execute();
            }
        };
        return location.execute();
    }

    public List<Server> getServers(){
        AbstractDbSelectExecutor<Server> server = new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }

            @Override
            public List execute() {
                return super.execute();
            }
        };
        return server.execute();
    }

    public List<Subject> getSubjects(){
        AbstractDbSelectExecutor<Subject> subject = new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }

            @Override
            public List execute() {
                return super.execute();
            }
        };
        return subject.execute();
    }

    public List<Subscription> getSubscriptions(){
        AbstractDbSelectExecutor<Subscription> subscription = new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }

            @Override
            public List execute() {
                return super.execute();
            }
        };
        return subscription.execute();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
        print(solution.getServers());
        print(solution.getSubjects());
        print(solution.getSubscriptions());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}
