package com.example.btvn_buoi4.controller;

import com.example.btvn_buoi4.service.GiangVienService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("giang-vien")
public class GiangVienController {

    private GiangVienService giangVienService = new GiangVienService();

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("list", giangVienService.getAll());
        return "hien-thi";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable String id) {
        giangVienService.xoaGiangVien(id);
        return "redirect:/giang-vien/hien-thi";
    }

    @GetMapping("search")
    public String search(@RequestParam String ten, Model model) {
        model.addAttribute("list", giangVienService.searchName(ten));
        return "hien-thi";

    }

    @GetMapping("giang-vien-nu")
    public String gvNu( Model model) {
        model.addAttribute("list" , giangVienService.giangvienNu());
        return "hien-thi";
    }
}
