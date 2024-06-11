package com.example.Assiment_java5.controller;

import com.example.Assiment_java5.entity.ChucVu;
import com.example.Assiment_java5.entity.MauSac;
import com.example.Assiment_java5.repository.ChucVuRepo;
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

@Controller
@RequestMapping("chuc-vu")
public class ChucVuController {

    @Autowired
    private ChucVuRepo chucVuRepo;

    @GetMapping("listCv")
    public String hienThi(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 10); // Mỗi trang 10 phần tử
        Page<ChucVu> chucVu = chucVuRepo.findAll(pageable);
        model.addAttribute("chucVu", chucVu.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", chucVu.getTotalPages());
        model.addAttribute("chucVuForm", new ChucVu());
        return "chucvu/hien-thi";
    }

    @PostMapping("saveOrUpdate")
    public String addOrUpdate(ChucVu chucVu, Model model) {
        chucVuRepo.save(chucVu);
        return "redirect:/chuc-vu/listCv";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Optional<ChucVu> chucVuOptional = chucVuRepo.findById(id);
        if (chucVuOptional.isPresent()) {
            ChucVu chucVu = chucVuOptional.get();
            model.addAttribute("chucVu2", chucVu);
            return "chucvu/edit";
        } else {
            return "redirect:/chuc-vu/listCv";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        chucVuRepo.deleteById(id);
        return "redirect:/chuc-vu/listCv";
    }
}
