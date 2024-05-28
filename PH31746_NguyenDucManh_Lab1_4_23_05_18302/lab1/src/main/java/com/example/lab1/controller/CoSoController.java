package com.example.lab1.controller;

import com.example.lab1.entity.CoSo;
import com.example.lab1.service.CoSoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("co-so")
public class CoSoController {

    private CoSoService coSoService = new CoSoService();

    @GetMapping("hien-thi-tat-ca")
    public String hienThiTatCa(Model model) {
        model.addAttribute("list", coSoService.getAllCoSoList());
        return "index";
    }

    @GetMapping("remove/{ma}")
    public String remove(@PathVariable String ma, Model model) {
        coSoService.delete(ma);
        model.addAttribute("list", coSoService.getAllCoSoList());
        return "redirect:/co-so/hien-thi-tat-ca";
    }

    @PostMapping("add")
    public String add(CoSo coSo, Model model) {
        coSoService.addCoSo(coSo);
        model.addAttribute("list", coSoService.getAllCoSoList());
        return "redirect:/co-so/hien-thi-tat-ca";
    }

    @GetMapping("view-update/{ma}")
    public String viewUpdate(Model model) {
        model.addAttribute("list", coSoService.getAllCoSoList());
        model.addAttribute("coSo", new CoSo());
        return "view-update";
    }

    @GetMapping("search")
    public String search(Model model, @RequestParam String ma) {
        model.addAttribute("list", coSoService.searchCoso(ma));
        return "index";
    }
}
