package com.example.Assiment_java5.controller;

import com.example.Assiment_java5.entity.Nsx;
import com.example.Assiment_java5.service.NsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("nha-sx")
public class NsxController {

    @Autowired
    private NsxService nsxService;

    @GetMapping("list")
    public String hienThi(Model model) {
        model.addAttribute("nsx", nsxService.getAllNsx());
        return "nsx/hien-thi";
    }

    @GetMapping("trangadd")
    public String list(Nsx nsx, Model model) {
        model.addAttribute("nsx", nsx);
        model.addAttribute("action", "saveOrUpdate");
        return "nsx/trangadd";
    }

    @PostMapping("saveOrUpdate")
    public String add(Nsx nsx, Model model) {
        nsxService.save(nsx);
        return "redirect:list";
    }
}
