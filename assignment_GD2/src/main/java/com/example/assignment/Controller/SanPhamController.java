package com.example.assignment.Controller;

import com.example.assignment.Entity.SPCT.ChiTietSp;
import com.example.assignment.Entity.SPCT.DongSp;
import com.example.assignment.Entity.SPCT.MauSac;
import com.example.assignment.Entity.SPCT.Nsx;
import com.example.assignment.Entity.SPCT.SanPham;
import com.example.assignment.Reporsitory.SPCT.DongSpRepo;
import com.example.assignment.Reporsitory.SPCT.MauSacRepo;
import com.example.assignment.Reporsitory.SPCT.NSXRepo;
import com.example.assignment.Reporsitory.SPCT.SanPhamChiTietRepo;
import com.example.assignment.Reporsitory.SPCT.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamChiTietRepo sanPhamChiTietRepo;
    @Autowired
    private SanPhamRepo sanPhamRepo;
    @Autowired
    private NSXRepo nsxRepo;
    @Autowired
    private MauSacRepo mauSacRepo;
    @Autowired
    private DongSpRepo dongSpRepo;

    @GetMapping("hien-thi")
    public String hienThi(Model md) {
        md.addAttribute("sp", sanPhamRepo.findAll());
        return "sanpham/hien-thi";
    }

    @GetMapping("trangadd")
    public String trangAdd(Model md) {
        md.addAttribute("spct", sanPhamChiTietRepo.findAll());
        md.addAttribute("sp", sanPhamRepo.findAll());
        md.addAttribute("nsx", nsxRepo.findAll());
        md.addAttribute("ms", mauSacRepo.findAll());
        md.addAttribute("dsp", dongSpRepo.findAll());
        return "sanpham/trangadd";
    }

    // add
    @PostMapping("saveOrUpdate")
    public String add(ChiTietSp spC,
                      @RequestParam Integer sanPhamId,
                      @RequestParam Integer idNsx,
                      @RequestParam Integer idMauSac,
                      @RequestParam Integer idDongSp) {
        SanPham sanPhamEntity = sanPhamRepo.findById(sanPhamId).orElse(null);
        Nsx nsx = nsxRepo.findById(idNsx).orElse(null);
        MauSac mauSacEntity = mauSacRepo.findById(idMauSac).orElse(null);
        DongSp dongSp = dongSpRepo.findById(idDongSp).orElse(null);
        spC.setIdSp(sanPhamId);
        spC.setDongSp(dongSp);
        spC.setMauSac(mauSacEntity);
        spC.setNsx(nsx);
        spC.setSanPham(sanPhamEntity);
        sanPhamChiTietRepo.save(spC);
        return "redirect:/san-pham/hien-thi";
    }

    // view ud
    @GetMapping("ud/{id}")
    public String viewUD(@PathVariable int id, Model md) {
        md.addAttribute("spct", sanPhamChiTietRepo.findById(id).get());
        md.addAttribute("sp", sanPhamRepo.findAll());
//        md.addAttribute("list", reporCT.findAll());
        md.addAttribute("nsxE", nsxRepo.findAll());
        md.addAttribute("msE", mauSacRepo.findAll());
        md.addAttribute("dspE", dongSpRepo.findAll());
        return "/SanPham/ud";
    }

    // ud
    @PostMapping("ud/{id}")
    public String ud(@ModelAttribute ChiTietSp spct,
                     @RequestParam Integer sanPhamId,
                     @RequestParam Integer NSXId,
                     @RequestParam Integer MSId,
                     @RequestParam Integer dspId) {
        SanPham sp = sanPhamRepo.findById(sanPhamId).orElse(null);
        Nsx nsx = nsxRepo.findById(NSXId).orElse(null);
        MauSac ms = mauSacRepo.findById(MSId).orElse(null);
        DongSp dsp = dongSpRepo.findById(dspId).orElse(null);
        spct.setDongSp(dsp);
        spct.setMauSac(ms);
        spct.setNsx(nsx);
        spct.setSanPham(sp);
        sanPhamChiTietRepo.save(spct);
        return "redirect:/san-pham/hien-thi";
    }

    // xoa
    @GetMapping("xoa/{id}")
    public String delete(@PathVariable Integer id) {
        sanPhamChiTietRepo.deleteById(id);
        return "redirect:/san-pham/hien-thi";
    }

//    @PostMapping("/san-pham/ud/{id}")
//    public String ud(@ModelAttribute ChiTietSpEntity spct,
//                     @RequestParam Integer sanPhamId
//                   ) {
//        SanPham sp = reporSP.findById(sanPhamId).orElse(null);
//        spct.setSpE(sp);
//        reporCT.save(spct);
//        return "redirect:/san-pham/hien-thi";
//    }
}

