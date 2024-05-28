package com.example.Fpoly_code2.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static List<Student> list = new ArrayList<Student>();
    public int add(Student student) {
        list.add(student);
        return 1;
    }
    public List<Student> getAll() {
        return list;
    }
}
