package com.example.ASM_JAVA5.controller;

import com.example.ASM_JAVA5.service.MauSacService;
import com.example.ASM_JAVA5.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("mauSac", mauSacService.getAllMauSac());
        return "mausac/hien-thi";
    }

}
