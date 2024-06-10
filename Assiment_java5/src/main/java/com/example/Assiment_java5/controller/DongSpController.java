package com.example.Assiment_java5.controller;

import com.example.Assiment_java5.entity.DongSp;
import com.example.Assiment_java5.repository.DongSpRepo;
import com.example.Assiment_java5.service.DongSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("dong-sp")
public class DongSpController {

    @Autowired
    private DongSpService dongSpService;
    @Autowired
    private DongSpRepo dongSpRepo;

    @GetMapping("list")
    public String hienThi(Model model) {
        model.addAttribute("dongSp", dongSpService.getAllDongSp());
        return "dongsp/hien-thi";
    }

    @GetMapping("trangadd")
    public String showAddForm(DongSp dongSp, Model model) {
        model.addAttribute("dongSpForm", dongSp);
        model.addAttribute("action", "/dong-sp/saveOrUpdate");
        return "dongsp/trangadd";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<DongSp> dongSpOptional = dongSpRepo.findById(id);
        if (dongSpOptional.isPresent()) {
            model.addAttribute("dongSpForm", dongSpOptional.get());
            model.addAttribute("action", "/dong-sp/saveOrUpdate");
            return "dongsp/trangadd";
        } else {
            return "redirect:/dong-sp/list";
        }
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
