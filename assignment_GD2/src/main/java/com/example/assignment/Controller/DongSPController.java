package com.example.assignment.Controller;

import com.example.assignment.Entity.SPCT.DongSp;
import com.example.assignment.Reporsitory.SPCT.DongSpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DongSPController {
    @Autowired
    DongSpRepo repor;

    @GetMapping("/dong-SP/hien-thi")
    public String hienThi(Model md) {
        md.addAttribute("list", repor.findAll());
        return "/DongSP/hien-thi";
    }

    //them
    @PostMapping("/dong-SP/add")
    public String add(@ModelAttribute DongSp dsp, Model md) {
        repor.save(dsp);
        return "redirect:/dong-SP/hien-thi";
    }

    //xoa
    @GetMapping("/dong-SP/delete/{id}")
    public String delete(@PathVariable Integer id) {
        repor.deleteById(id);
        return "redirect:/dong-SP/hien-thi";
    }

    // view-ud
    @GetMapping("/dong-SP/update/{id}")
    public String ViewUpdate(@PathVariable Integer id, Model md) {
        md.addAttribute("lis", repor.findById(id).get());
        return "/DongSP/ud";
    }

    // ud
    @PostMapping("/dong-SP/update/{id}")
    public String Update(@PathVariable Integer id, @ModelAttribute DongSp dsp) {
        dsp.setId(id);
        repor.save(dsp);
        return "redirect:/Nsx/hien-thi";
    }
}
