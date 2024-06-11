package com.example.Assiment_java5.controller;

import com.example.Assiment_java5.entity.ChucVu;
import com.example.Assiment_java5.entity.CuaHang;
import com.example.Assiment_java5.repository.ChucVuRepo;
import com.example.Assiment_java5.repository.CuaHangRepo;
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
@RequestMapping("cua-hang")
public class CuaHangController {

    @Autowired
    private CuaHangRepo cuaHangRepo;

    @GetMapping("list")
    public String hienThi(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 10); // Mỗi trang 10 phần tử
        Page<CuaHang> cuaHangs = cuaHangRepo.findAll(pageable);
        model.addAttribute("cuaHang", cuaHangs.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", cuaHangs.getTotalPages());
        model.addAttribute("cuahangForm", new CuaHang());
        return "cuahang/hien-thi";
    }

    @PostMapping("saveOrUpdate")
    public String addOrUpdate(CuaHang cuaHang, Model model) {
        cuaHangRepo.save(cuaHang);
        return "redirect:/cua-hang/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Optional<CuaHang> cuaHangOptional = cuaHangRepo.findById(id);
        if (cuaHangOptional.isPresent()) {
            CuaHang cuaHang = cuaHangOptional.get();
            model.addAttribute("cuahangForm", cuaHang);
            return "cuahang/edit";
        } else {
            return "redirect:/cua-hang/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        cuaHangRepo.deleteById(id);
        return "redirect:/cua-hang/list";
    }
}
