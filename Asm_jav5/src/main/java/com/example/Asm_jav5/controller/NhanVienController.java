package com.example.Asm_jav5.controller;

import com.example.Asm_jav5.repository.CategoryRepository;
import com.example.Asm_jav5.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private CategoryRepository CategoryRepository;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("nhanVien", nhanVienService.getAllNhanVien());
        return "index";
    }
    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("list", CategoryRepository.findAll());
        return "hien-thi";
    }
}
