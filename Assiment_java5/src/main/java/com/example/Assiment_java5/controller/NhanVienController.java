package com.example.Assiment_java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Scanner;

@Controller
public class NhanVienController {

    @GetMapping("/hello-world")
    public String nhanvien() {
        return "welcome";
    }
    @PostMapping("/display")
    public String display(Model model) {
        String name = "Manhdz";
        model.addAttribute("name", name);
        return "display";
    }
}

