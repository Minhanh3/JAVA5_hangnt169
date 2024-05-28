package com.example.Fpoly_code2.controller;

import com.example.Fpoly_code2.model.Major;
import com.example.Fpoly_code2.model.MajorDAO;
import com.example.Fpoly_code2.model.Student;
import com.example.Fpoly_code2.model.StudentDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/student")
public class StudentController {
    MajorDAO majorDAO = new MajorDAO();
    StudentDAO studentDAO = new StudentDAO();

    @GetMapping("/student")
    public String addOrEdit(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@ModelAttribute("student") Student student) {
        Major m = majorDAO.getMajorById(student.getMajor().getId());
        student.setMajor(m);
        studentDAO.add(student);
        System.out.println("Student added : " + student.toString());
        System.out.println("Student added size: " + studentDAO.list.size());
        return "student-form";
    }
    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("list_student", studentDAO.getAll());
        return "view-student";
    }
    @ModelAttribute("list_major")
    public List<Major> getMajors() {
        return majorDAO.getAll();
    }
}
