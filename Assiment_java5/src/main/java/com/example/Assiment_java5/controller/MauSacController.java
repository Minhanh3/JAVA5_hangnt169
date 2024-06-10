package com.example.Assiment_java5.controller;

import com.example.Assiment_java5.entity.MauSac;
import com.example.Assiment_java5.repository.MauSacRepo;
import com.example.Assiment_java5.service.DongSpService;
import com.example.Assiment_java5.service.MauSacService;
import com.example.Assiment_java5.service.NsxService;
import com.example.Assiment_java5.service.SanPhamService;
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
@RequestMapping("mau-sac")
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private MauSacRepo mauSacRepo;

    @GetMapping("list")
    public String hienThi(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 10); // Mỗi trang 10 phần tử
        Page<MauSac> mauSacs = mauSacRepo.findAll(pageable);
        model.addAttribute("mauSac", mauSacs.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", mauSacs.getTotalPages());
        model.addAttribute("mauSacForm", new MauSac());
        return "mausac/hien-thi";
    }

    @PostMapping("saveOrUpdate")
    public String addOrUpdate(MauSac mauSac, Model model) {
        mauSacService.save(mauSac);
        return "redirect:/mau-sac/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Optional<MauSac> mauSacOptional = mauSacRepo.findById(id);
        if (mauSacOptional.isPresent()) {
            MauSac mauSac = mauSacOptional.get();
            model.addAttribute("mauSacForm2", mauSac);
            return "mausac/edit";
        } else {
            return "redirect:/mau-sac/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        mauSacRepo.deleteById(id);
        return "redirect:/mau-sac/list";
    }
}
