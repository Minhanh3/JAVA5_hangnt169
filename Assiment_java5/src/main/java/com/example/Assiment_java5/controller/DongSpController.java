package com.example.Assiment_java5.controller;

import com.example.Assiment_java5.entity.DongSp;
import com.example.Assiment_java5.repository.DongSpRepo;
import com.example.Assiment_java5.service.DongSpService;
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
@RequestMapping("dong-sp")
public class DongSpController {

    @Autowired
    private DongSpService dongSpService;
    @Autowired
    private DongSpRepo dongSpRepo;

    @GetMapping("list")
    public String hienThi(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 10); // Mỗi trang 10 phần tử
        Page<DongSp> dongSps = dongSpRepo.findAll(pageable);
        model.addAttribute("dongSp1", dongSps.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", dongSps.getTotalPages());
        model.addAttribute("dongSp", new DongSp());
        return "dongsp/hien-thi";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<DongSp> dongSpOptional = dongSpRepo.findById(id);
        if (dongSpOptional.isPresent()) {
            model.addAttribute("dongSpForm", dongSpOptional.get());
            model.addAttribute("action", "/dong-sp/update"); // Đường dẫn cập nhật dòng sản phẩm
            return "dongsp/edit"; // Trang chỉnh sửa
        } else {
            return "redirect:/dong-sp/list";
        }
    }

    @PostMapping("/update")
    public String update(DongSp dongSp) {
        dongSpService.save(dongSp);
        return "redirect:/dong-sp/list"; // Chuyển hướng về trang hiển thị
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(DongSp dongSp) {
        dongSpService.save(dongSp);
        return "redirect:/dong-sp/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        dongSpRepo.deleteById(id);
        return "redirect:/dong-sp/list";
    }
}
