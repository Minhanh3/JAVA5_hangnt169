package com.example.hello.controller;

import com.example.hello.entity.DatPhong;
import com.example.hello.repository.DatPhongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dat-phong")
public class DatPhongController {

    @Autowired
    private DatPhongRepo datPhongRepo;

    @GetMapping("hien-thi")
    public String getAllPhong(Model model) {
        model.addAttribute("phongs", datPhongRepo.findAll());
        return "datphong";
    }

    @PostMapping("addDatPhong")
    public String savePhong(DatPhong datPhong) {
        datPhongRepo.save(datPhong);
        return "redirect:/dat-phong/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("datPhong", datPhongRepo.findById(id).get());
        return "editDatPhong";
    }

    @GetMapping("delete/{id}")
    public String deletePhong(Model model, @PathVariable int id) {
        datPhongRepo.deleteById(id);
        return "redirect:/dat-phong/hien-thi";
    }

    @PostMapping("update/{id}")
    public String update(DatPhong datPhong, @PathVariable int id) {

        datPhongRepo.save(datPhong);
        return "redirect:/dat-phong/hien-thi";
    }

}
