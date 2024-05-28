package com.example.btvn_buoi5.controller;

import com.example.btvn_buoi5.entity.GiangVien;
import com.example.btvn_buoi5.service.GiangVienServie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("giang-vien")
public class GiangVienController {
    private GiangVienServie giangVienServie = new GiangVienServie();

    @GetMapping("hien-thi-tat-ca")
    public String hienThiTatCa(Model model) {
        model.addAttribute("list", giangVienServie.getAll());
        return "giang-vien";
    }

    @GetMapping("detail/{ma}")
    public String detail(@PathVariable("ma") String ma, Model model) {
        GiangVien giangVien = giangVienServie.detail(ma);
        model.addAttribute("gv", giangVien);
        model.addAttribute("list", giangVienServie.getAll());
        return "giang-vien";
    }
    @GetMapping("delete/{ma}")
    public String delete(@PathVariable("ma") String ma, Model model) {
        giangVienServie.delete(ma);
        model.addAttribute("list", giangVienServie.getAll());
        return "redirect:/giang-vien/hien-thi-tat-ca";
    }
    @GetMapping("searchName")
    public String searchName(@RequestParam String ten , Model model) {
        model.addAttribute("list", giangVienServie.searchname(ten));
        return "giang-vien";
    }
    @PostMapping("add")
    public String add(@ModelAttribute("gv") GiangVien giangVien) {
        giangVienServie.add(giangVien);
        return "redirect:/giang-vien/hien-thi-tat-ca";
    }
}
