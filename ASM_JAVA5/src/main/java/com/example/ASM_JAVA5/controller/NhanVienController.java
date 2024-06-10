package com.example.ASM_JAVA5.controller;

import com.example.ASM_JAVA5.repository.NhanVienRepo;
import com.example.ASM_JAVA5.service.NhanVienService;
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

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("nhanvien", nhanVienService.getAllNhanVien());
        return "nhanvien/hien-thi";
    }

}
