package com.example.demo.controller;

import com.example.demo.request.SinhVienRequest;
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
        model.addAttribute("sVienRequest" , new SinhVienRequest());
        return "dang-ky";
    }

    @PostMapping("/dang-ky-thanh-cong")
    public String dangKyThanhCong(Model model , @Valid SinhVienRequest sVienRequest , BindingResult Result){
        if(Result.hasErrors()){
            return "dang-ky";
        }

        model.addAttribute("MSSV", sVienRequest.getMSSV());
        model.addAttribute("hoVaTen" ,sVienRequest.getHoVaTen());
        model.addAttribute("tuoi" ,sVienRequest.getTuoi());
        model.addAttribute("gioiTinh" ,sVienRequest.getGioiTinh());
        model.addAttribute("kyHoc" ,sVienRequest.getKyHoc());
        model.addAttribute("nganhHoc" ,sVienRequest.getNganhHoc());
        model.addAttribute("queQuan" ,sVienRequest.getQueQuan());
        model.addAttribute("matKhau" ,sVienRequest.getMatKhau());
        model.addAttribute("cfMatKhau" ,sVienRequest.getCfMatKhau());

        return "dang-ky-thanh-cong";
    }
}
