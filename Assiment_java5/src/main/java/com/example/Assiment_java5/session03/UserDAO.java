package com.example.Assiment_java5.session03;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static List<User> ls = new ArrayList<User>();

    public static User findByUserName(String userName) {
        for (User u : ls) {
            if (u.getUsername().equals(userName)) {
                return u;
            }
        }
        return null;
    }

    public static int updateUser(User user) {
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getUsername().equals(user.getUsername())) {
                ls.set(i, user);
                return i;
            }
        }
        return -1;
    }

    public static int save(User user) {
        if (findByUserName(user.getUsername()) != null) {
            updateUser(user);
        } else {
            ls.add(user);
        }
        return 1;
    }

    public static int delete(String userName) {
        User u = findByUserName(userName);
        if (u != null) {
            ls.remove(u);
            return 1;
        }
        return 0;
    }
    public static List<User> getAll() {
        if (ls == null) {
            System.out.printf("Danh sach rong");
            return null;
        }
        return ls;
    }
}
