package com.example.btnvn_buoi3.controller;

import com.example.btnvn_buoi3.Requiest.SinhVienRequi;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DangKyController {

    @GetMapping("/dang-ky")
    public String dangKy(Model model){
        model.addAttribute("sinhvienRequi", new SinhVienRequi());
        return "dang-ky";
    }

    @PostMapping("/dang-ky-thanh-cong")
    public String dangKyThanhCong(Model model ,@Valid SinhVienRequi sinhvienRequi , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "dang-ky";
        }
        model.addAttribute("mssv", sinhvienRequi.getMssv());
        model.addAttribute("hoVaTen" ,sinhvienRequi.getHoVaTen());
        model.addAttribute("tuoi" ,sinhvienRequi.getTuoi());
        model.addAttribute("gioiTinh" ,sinhvienRequi.getGioiTinh());
        model.addAttribute("kyHoc" ,sinhvienRequi.getKyHoc());
        model.addAttribute("nganhHoc" ,sinhvienRequi.getNganhHoc());
        model.addAttribute("queQuan" ,sinhvienRequi.getQueQuan());
        model.addAttribute("matKhau" ,sinhvienRequi.getMatKhau());
        model.addAttribute("cfMatKhau" ,sinhvienRequi.getCfMatKhau());

        return "dang-ky-thanh-cong";
    }
}
