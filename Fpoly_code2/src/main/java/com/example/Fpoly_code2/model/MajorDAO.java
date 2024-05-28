package com.example.Fpoly_code2.model;

import java.util.ArrayList;
import java.util.List;

public class MajorDAO {
    private static List<Major> list = new ArrayList<>();

    public List<Major> getAll() {
        list.clear();
        list.add(new Major(1, "WEB"));
        list.add(new Major(2, "UDPM"));
        list.add(new Major(3, "TKDH"));
        return list;
    }
    public Major getMajorById(int id) {
        for (Major major : list) {
            if (major.getId() == id) {
                return major;
            }
        }
        return null;
    }
}
