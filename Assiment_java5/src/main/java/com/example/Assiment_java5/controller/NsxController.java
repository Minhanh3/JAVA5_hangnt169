package com.example.Assiment_java5.controller;

import com.example.Assiment_java5.entity.MauSac;
import com.example.Assiment_java5.entity.Nsx;
import com.example.Assiment_java5.repository.NSXRepo;
import com.example.Assiment_java5.service.NsxService;
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
@RequestMapping("nha-sx")
public class NsxController {

    @Autowired
    private NsxService nsxService;
    @Autowired
    private NSXRepo nsxRepo;

    @GetMapping("list")
    public String hienThi(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5); // Mỗi trang 10 phần tử
        Page<Nsx> nsxPage = nsxRepo.findAll(pageable);
        model.addAttribute("nsx", nsxPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", nsxPage.getTotalPages());
        model.addAttribute("nsx2", new Nsx());
        return "nsx/hien-thi";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Optional<Nsx> nsxOptional = nsxRepo.findById(id);
        if (nsxOptional.isPresent()) {
            Nsx nsx = nsxOptional.get();
            model.addAttribute("nsx5", nsx);
            return "nsx/edit"; // Trang chỉnh sửa
        } else {
            return "redirect:/nha-sx/list";
        }
    }

    @PostMapping("saveOrUpdate")
    public String add(Nsx nsx, Model model) {
        nsxService.save(nsx);
        return "redirect:/nha-sx/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        nsxRepo.deleteById(id); // Xóa NSX theo ID
        return "redirect:/nha-sx/list"; // Chuyển hướng về trang danh sách
    }
}
