package com.example.Assiment_java5.controller;

import com.example.Assiment_java5.entity.KhachHang;
import com.example.Assiment_java5.repository.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangRepo khachHangRepo;

    @GetMapping("listKh")
    public String hienThispct(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 10); // Mỗi trang 5 phần tử
        Page<KhachHang> khachHangs = khachHangRepo.findAll(pageable);
        model.addAttribute("khachHangs", khachHangs.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", khachHangs.getTotalPages());
        return "khachhang/hien-thi";
    }

    @PostMapping("saveOrUpdate")
    public String addKhachHang(KhachHang khachHang) {
        khachHang.setMa(generateRandomCode());
        khachHangRepo.save(khachHang);
        return "redirect:/khach-hang/listKh";
    }

    @GetMapping("/delete/{id}")
    public String deleteKhachHang(@PathVariable Integer id) {
        khachHangRepo.deleteById(id);
        return "redirect:/khach-hang/listKh";
    }

    @GetMapping("/edit/{id}")
    public String editKhachHang(@PathVariable Integer id, Model model) {
        Optional<KhachHang> khachHangOptional = khachHangRepo.findById(id);
        KhachHang khachHang = khachHangOptional.orElse(new KhachHang());
        if (khachHangOptional.isPresent()) {
            model.addAttribute("khachHang", khachHang);
            return "khachhang/edit";
        } else {
            // Xử lý khi không tìm thấy khách hàng
            return "redirect:/khach-hang/listKh";
        }
    }

    private String generateRandomCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(5);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}
