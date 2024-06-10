package com.example.Assiment_java5.controller;

import com.example.Assiment_java5.entity.ChiTietSp;
import com.example.Assiment_java5.entity.DongSp;
import com.example.Assiment_java5.entity.MauSac;
import com.example.Assiment_java5.entity.Nsx;
import com.example.Assiment_java5.entity.SanPham;
import com.example.Assiment_java5.repository.ChiTietSpRepo;
import com.example.Assiment_java5.repository.DongSpRepo;
import com.example.Assiment_java5.repository.MauSacRepo;
import com.example.Assiment_java5.repository.NSXRepo;
import com.example.Assiment_java5.repository.SanPhamRepo;
import com.example.Assiment_java5.service.DongSpService;
import com.example.Assiment_java5.service.MauSacService;
import com.example.Assiment_java5.service.NsxService;
import com.example.Assiment_java5.service.SanPhamService;
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

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
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

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @Autowired
    private ChiTietSpRepo chiTietSpRepo;

    @Autowired
    private NSXRepo nsxRepo;

    @Autowired
    private DongSpRepo dongSpRepo;

    @Autowired
    private MauSacRepo mauSacRepo;


    @PostMapping("addSanPham")
    public SanPham addSanPhamForChisp(SanPham sanPham) {
        return sanPhamService.save(sanPham);
    }

//    @GetMapping("listSpct")
//    public String hienThispct(Model model) {
//        model.addAttribute("chiTietSp", chiTietSpRepo.findAll());
//        return "sanpham/hien-thi-spct";
//    }

    @GetMapping("listSpct")
    public String hienThispct(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 10); // Mỗi trang 5 phần tử
        Page<ChiTietSp> sanPhams = chiTietSpRepo.findAll(pageable);
        model.addAttribute("chiTietSp", sanPhams.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sanPhams.getTotalPages());
        return "sanpham/hien-thi-spct";
    }

    @GetMapping("list")
    public String phanTrang(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 11); // Mỗi trang 5 phần tử
        Page<SanPham> sanPhams = sanPhamRepo.findAll(pageable);
        model.addAttribute("sanPham", sanPhams.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sanPhams.getTotalPages());
        return "sanpham/hien-thi";
    }

    @GetMapping("trangadd")
    public String trangAdd(Model md) {
//        md.addAttribute("spct", chiTietSpRepo.findAll());
        md.addAttribute("sp", sanPhamService.getAllSanPham());
        md.addAttribute("nsx", nsxService.getAllNsx());
        md.addAttribute("ms", mauSacService.getAllMauSac());
        md.addAttribute("dsp", dongSpService.getAllDongSp());
        return "sanpham/trangadd";
    }

    @GetMapping("trangadd2")
    public String trangAdd2(Model md) {
        md.addAttribute("sp", sanPhamService.getAllSanPham());
        md.addAttribute("nsx", nsxService.getAllNsx());
        md.addAttribute("ms", mauSacService.getAllMauSac());
        md.addAttribute("dsp", dongSpService.getAllDongSp());
        return "sanpham/trangaddSanPham";
    }

    @PostMapping("saveOrUpdatesp")
    public String add2(SanPham spC) {
        sanPhamService.save(spC);
        return "redirect:list";
    }

    @PostMapping("saveOrUpdate")
    public String add(ChiTietSp spC,
                      @RequestParam Integer sanPhamId,
                      @RequestParam Integer idNsx,
                      @RequestParam Integer idMauSac,
                      @RequestParam Integer idDongSp) {
        sanPhamService.addspct(spC, sanPhamId, idNsx, idMauSac, idDongSp);
        return "redirect:san-pham/listSpct";
    }

    @GetMapping("edit")
    public String edit(@RequestParam int id,
//                       @RequestParam int sanPhamId,
//                       @RequestParam int idNsx, @RequestParam int idMauSac,
//                       @RequestParam int idDongSp,
                       Model model) {
        try {
            ChiTietSp chiTietSp = chiTietSpRepo.findById(id).get();
            model.addAttribute("spct", chiTietSp);
            model.addAttribute("sp", sanPhamService.getAllSanPham());
            model.addAttribute("nsx", nsxService.getAllNsx());
            model.addAttribute("ms", mauSacService.getAllMauSac());
            model.addAttribute("dsp", dongSpService.getAllDongSp());
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/sanpham/hien-thi";
        }
        return "sanpham/editSanPham";
    }

    @PostMapping("updateProduct")
    public String updateProDuct(@RequestParam int id,
                                @RequestParam int sanPhamId,
                                @RequestParam int idNsx, @RequestParam int idMauSac,
                                @RequestParam int idDongSp,
                                Model model) {
        try {
            ChiTietSp chiTietSp = chiTietSpRepo.findById(id).get();
            SanPham sanPham = sanPhamRepo.findById(sanPhamId).get();
            Nsx nsx = nsxRepo.findById(idNsx).get();
            MauSac mauSac = mauSacRepo.findById(idMauSac).get();
            DongSp dongSp = dongSpRepo.findById(idDongSp).get();
            sanPham.setTen(sanPham.getTen());
            nsx.setTen(nsx.getTen());
            mauSac.setTen(mauSac.getTen());
            dongSp.setTen(dongSp.getTen());
            model.addAttribute("spct", chiTietSp);
            chiTietSp.setNamBh(chiTietSp.getNamBh());
            chiTietSp.setMoTa(chiTietSp.getMoTa());
            chiTietSp.setSoLuongTon(chiTietSp.getSoLuongTon());
            chiTietSp.setGiaNhap(chiTietSp.getGiaNhap());
            chiTietSp.setGiaBan(chiTietSp.getGiaBan());
            chiTietSpRepo.save(chiTietSp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/sanpham/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Optional<SanPham> sanPhamOptional = sanPhamRepo.findById(id);
        if (sanPhamOptional.isPresent()) {
            List<ChiTietSp> chiTietSps = sanPhamOptional.get().getChiTietSps();
            chiTietSpRepo.deleteAll(chiTietSps);
            sanPhamRepo.deleteById(id);
        }
        return "redirect:/san-pham/list";
    }
}
