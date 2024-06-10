package com.example.assignment.Controller;

import com.example.assignment.Entity.SPCT.Nsx;
import com.example.assignment.Reporsitory.SPCT.NSXRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NSXController {
    @Autowired
    NSXRepo repor;

    @GetMapping("/Nsx/hien-thi")
    public String hienThi(Model md) {
        md.addAttribute("list", repor.findAll());
        return "/NSX/hien-thi";
    }

    //them
    @PostMapping("/NSX/add")
    public String add(@ModelAttribute Nsx nsx, Model md) {
        if (repor.existsByMa(nsx.getMa())) {
            md.addAttribute("errorMessage", "NSX với mã này đã tồn tại");
            return "redirect:/Nsx/hien-thi";
        }
        repor.save(nsx);
        return "redirect:/Nsx/hien-thi";
    }

    //xoa
    @GetMapping("/NSX/delete/{id}")
    public String delete(@PathVariable Integer id) {
        repor.deleteById(id);
        return "redirect:/Nsx/hien-thi";
    }

    // view-ud
    @GetMapping("/NSX/update/{id}")
    public String ViewUpdate(@PathVariable Integer id, Model md) {
        md.addAttribute("lis", repor.findById(id).get());
        return "/NSX/ud";
    }

    // ud
    @PostMapping("/NSX/update/{id}")
    public String Update(@PathVariable Integer id, @ModelAttribute Nsx nsx) {
        nsx.setId(id);
        repor.save(nsx);
        return "redirect:/Nsx/hien-thi";
    }
}
