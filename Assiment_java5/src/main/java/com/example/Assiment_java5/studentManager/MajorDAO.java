package com.example.Assiment_java5.studentManager;

import java.util.ArrayList;
import java.util.List;

public class MajorDAO {
    private static List<Major> list = new ArrayList<Major>();

    public List<Major> getAll() {
        list.add(new Major(1, "Major 1"));
        list.add(new Major(2, "Major 2"));
        list.add(new Major(3, "Major 3"));
        return list;
    }
}
