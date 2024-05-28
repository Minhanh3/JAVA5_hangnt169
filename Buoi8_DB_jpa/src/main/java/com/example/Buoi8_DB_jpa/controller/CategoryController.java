package com.example.Buoi8_DB_jpa.controller;

import com.example.Buoi8_DB_jpa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cate")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("list", categoryRepository.findAll());
        return "hien-thi";
    }
}
