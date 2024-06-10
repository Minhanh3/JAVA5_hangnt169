package com.example.demo.controller;

import com.example.demo.repository.CategoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryInterface repos;

    @GetMapping("/hienthi")
    public String index(Model model){
        model.addAttribute("list", repos.findAll());
        
        return "index";
    }
}
