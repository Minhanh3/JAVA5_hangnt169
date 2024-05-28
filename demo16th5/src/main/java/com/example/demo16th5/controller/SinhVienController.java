package com.example.demo16th5.controller;

import com.example.demo16th5.entity.SinhVien;
import com.example.demo16th5.service.SinhVienService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("sinh-vien")
public class SinhVienController {

    private SinhVienService sinhVienService = new SinhVienService();

    @GetMapping("/hien-thi")
    public String sinhVien(Model model) {
        model.addAttribute("list", sinhVienService.getALL());
        return "sinh-vien";
    }

    @GetMapping("/remove/{ma}")
    public String remove(@PathVariable String ma) {
        sinhVienService.xoaSinhVien(ma);
        return "redirect:/sinh-vien/hien-thi";
    }

    @GetMapping("/view-add")
    public String add() {
        return "add-sinh-vien";
    }

    @PostMapping("add")
    public String saveSinhvien(
            SinhVien sinhVien
//            @RequestParam String mssv,
//                               @RequestParam String ten,
//                               @RequestParam int tuoi,
//                               @RequestParam String diaChi,
//                               @RequestParam boolean gioiTinh
    ) {
//        SinhVien sinhVien = new SinhVien(mssv , ten , tuoi , diaChi , gioiTinh);
        sinhVienService.addsv(sinhVien);
        return "redirect:/sinh-vien/hien-thi";
    }
    @GetMapping("/detail/{ma}")
    public String detailsv(@PathVariable String ma , Model model) {
        SinhVien sinhVien = sinhVienService.detailSv(ma) ;
        model.addAttribute("sv" , sinhVien);
        return "detail-sinh-vien";
    }
    @GetMapping("/view-update/{ma}")
    public String updateSv(@PathVariable String ma , Model model) {
        SinhVien sinhVien = sinhVienService.detailSv(ma) ;
        model.addAttribute("sv" , sinhVien);
        return "update-sinh-vien";
    }

}
