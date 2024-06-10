package com.example.ASM_JAVA5.controller;

import com.example.ASM_JAVA5.entity.ChiTietSp;
import com.example.ASM_JAVA5.entity.DongSp;
import com.example.ASM_JAVA5.entity.MauSac;
import com.example.ASM_JAVA5.entity.Nsx;
import com.example.ASM_JAVA5.entity.SanPham;
import com.example.ASM_JAVA5.service.DongSpService;
import com.example.ASM_JAVA5.service.MauSacService;
import com.example.ASM_JAVA5.service.NhanVienService;
import com.example.ASM_JAVA5.service.NsxService;
import com.example.ASM_JAVA5.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
@RequestMapping("san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private DongSpService dongSpService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private NsxService nsxService;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("sanPham", sanPhamService.getAllSanPham());
        return "sanpham/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String viewDetail(@PathVariable Integer id, Model model) {
        ChiTietSp chiTietSp = sanPhamService.getChiTietSpById(id);
        model.addAttribute("chiTietSp", chiTietSp);
        return "sanpham/detail";
    }

    @GetMapping("hien-thi-all")
    public List<SanPham> hienThi() {
        return sanPhamService.getAllSanPham();
    }

    @PostMapping("addSanPham2")
    public SanPham addSanPhamNew2(SanPham sanPham) {
        return sanPhamService.add(sanPham);
    }

    @GetMapping("add")
    public String addSanPham(Model model) {
        List<DongSp> dsDongSp = dongSpService.getAllDongSp();
        List<MauSac> dsMauSac = mauSacService.getAllMauSac();
        List<Nsx> dsNsx = nsxService.getAllNsx();
        model.addAttribute("dsDongSp", dsDongSp);
        model.addAttribute("dsMauSac", dsMauSac);
        model.addAttribute("dsNsx", dsNsx);
        return "sanpham/add";
    }

    @PostMapping("addSanPham")
    public String addSanPhamNew(SanPham sanPham) {
        sanPhamService.add(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

}
