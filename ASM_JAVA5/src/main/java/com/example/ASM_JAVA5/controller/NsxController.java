package com.example.ASM_JAVA5.controller;

import com.example.ASM_JAVA5.service.DongSpService;
import com.example.ASM_JAVA5.service.NsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("nsx")
public class NsxController {

    @Autowired
    private NsxService nsxService;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("nsx", nsxService.getAllNsx());
        return "nsx/hien-thi";
    }

}
