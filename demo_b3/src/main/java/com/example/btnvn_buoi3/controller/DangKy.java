package com.example.btnvn_buoi3.controller;


import com.example.btnvn_buoi3.Requiest.DangKyRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DangKy {
    @GetMapping("/dang-ky")
    public String dangKy(Model model) {
        model.addAttribute("dangKyRequest", new DangKyRequest());
        return "dang-ky";
    }

    @PostMapping("/ket-qua")
    public String ketQua(Model model, @Valid DangKyRequest dangKyRequest, BindingResult Result) {
        if (Result.hasErrors()) {
            return "dang-ky";
        }
        model.addAttribute("hoVaTen", dangKyRequest.getHoVaTen());
        model.addAttribute("tuoi", dangKyRequest.getTuoi());
        model.addAttribute("nganhHoc", dangKyRequest.getNganhHoc());
        model.addAttribute("queQuan", dangKyRequest.getQueQuan());
        model.addAttribute("matKhau", dangKyRequest.getMatKhau());
        model.addAttribute("cfMatKhau", dangKyRequest.getCfMatKhau());
//        model.addAttribute("mssv", dangKyRequest.getMssv());
//        model.addAttribute("hoVaTen" ,dangKyRequest.getHoVaTen());
//        model.addAttribute("tuoi" ,dangKyRequest.getTuoi());
//        model.addAttribute("gioiTinh" ,dangKyRequest.getGioiTinh());
//        model.addAttribute("kyHoc" ,dangKyRequest.getKyHoc());
//        model.addAttribute("nganhHoc" ,dangKyRequest.getNganhHoc());
//        model.addAttribute("queQuan" ,dangKyRequest.getQueQuan());
//        model.addAttribute("matKhau" ,dangKyRequest.getMatKhau());
//        model.addAttribute("cfMatKhau" ,dangKyRequest.getCfMatKhau());
        return "ket-qua";
    }
}