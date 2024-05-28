package com.example.btvn_buoi6.controller;

import com.example.btvn_buoi6.model.ThucVat;
import com.example.btvn_buoi6.service.ThucVatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("thuc-vat")
public class ThucVatController {

    private ThucVatService thucVatService = new ThucVatService();

    @GetMapping("hien-thi-tat-ca")
    public String hienThiTatCa(Model model) {
        model.addAttribute("list", thucVatService.getAllThucVat());
        return "thuc-vat";
    }

    @PostMapping("add")
    public String addThucVat(ThucVat thucVat) {
        thucVatService.addThucVat(thucVat);
        return "redirect:/thuc-vat/hien-thi-tat-ca";
    }

    @GetMapping("remove/{id}")
    public String removeThucVat(@PathVariable Integer id, Model model) {
        thucVatService.remove(id);
        model.addAttribute("list", thucVatService.getAllThucVat());
        return "redirect:/thuc-vat/hien-thi-tat-ca";
    }

    @GetMapping("search")
    public String searchName(@RequestParam String ten, Model model) {
        model.addAttribute("list", thucVatService.searchThucVat(ten));
        return "thuc-vat";
    }

}
