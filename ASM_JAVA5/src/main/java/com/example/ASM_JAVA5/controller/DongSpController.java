package com.example.ASM_JAVA5.controller;

import com.example.ASM_JAVA5.service.DongSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dong-sp")
public class DongSpController {

    @Autowired
    private DongSpService dongspService;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("dongSp", dongspService.getAllDongSp());
        return "dongsp/hien-thi";
    }

}
