package com.example.btvn_buoi9.controller;

import com.example.btvn_buoi9.entity.LopHoc;
import com.example.btvn_buoi9.repository.LopHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("lop-hoc")
public class LopHocController {

    @Autowired
    private LopHocRepository lopHocRepository;

    @GetMapping("list")
    public String hienThi(Model model) {
        model.addAttribute("list", lopHocRepository.findAll());
        return "hien-thi";
    }

    @PostMapping("add")
    public String add(LopHoc lopHoc) {
        lopHocRepository.save(lopHoc);
        return "redirect:/list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id ) {
        Optional<LopHoc> optionalLopHoc = lopHocRepository.findById(id);
        optionalLopHoc.ifPresent(lopHoc -> lopHocRepository.delete(lopHoc));
        return "redirect:/lop-hoc/list";
    }
}
