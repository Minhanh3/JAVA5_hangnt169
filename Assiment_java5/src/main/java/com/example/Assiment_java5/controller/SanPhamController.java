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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.Random;

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

    @GetMapping("trangaddChiTietSanPham")
    public String trangAdd(Model md) {
        md.addAttribute("sp", sanPhamService.getAllSanPham());
        md.addAttribute("nsx", nsxService.getAllNsx());
        md.addAttribute("ms", mauSacService.getAllMauSac());
        md.addAttribute("dsp", dongSpService.getAllDongSp());
        md.addAttribute("CtSanPham", new ChiTietSp());
        return "sanpham/trangadd";
    }

    @GetMapping("listSpct")
    public String hienThispct(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 7); // Mỗi trang 5 phần tử
        Page<ChiTietSp> sanPhams = chiTietSpRepo.findAll(pageable);
        model.addAttribute("chiTietSp", sanPhams.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sanPhams.getTotalPages());
        return "sanpham/hien-thi-spct";
    }

    @PostMapping("saveOrUpdate")
    public String add(ChiTietSp spC,
                      @RequestParam Integer sanPhamId,
                      @RequestParam Integer idNsx,
                      @RequestParam Integer idMauSac,
                      @RequestParam Integer idDongSp) {
        sanPhamService.addspct(spC, sanPhamId, idNsx, idMauSac, idDongSp);
        return "redirect:/san-pham/listSpct";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        try {
            ChiTietSp chiTietSp = chiTietSpRepo.findById(id).get();
            model.addAttribute("spct", chiTietSp);
            model.addAttribute("sp", sanPhamService.getAllSanPham());
            model.addAttribute("nsx", nsxService.getAllNsx());
            model.addAttribute("ms", mauSacService.getAllMauSac());
            model.addAttribute("dsp", dongSpService.getAllDongSp());
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/san-pham/listSpct";
        }
        return "sanpham/editSanPhamChiTiet";
    }

    @PostMapping("updateProduct")
    public String updateProduct(@ModelAttribute ChiTietSp spct,
                                @RequestParam int id, // Thêm ID để lấy đối tượng hiện tại
                                @RequestParam int sanPhamId,
                                @RequestParam int idNsx,
                                @RequestParam int idMauSac,
                                @RequestParam int idDongSp) {
        try {
            // Lấy đối tượng hiện tại từ cơ sở dữ liệu
            ChiTietSp existingSpct = chiTietSpRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
            // Lấy các đối tượng liên quan
            SanPham sanPham = sanPhamRepo.findById(sanPhamId).get();
            Nsx nsx = nsxRepo.findById(idNsx).get();
            MauSac mauSac = mauSacRepo.findById(idMauSac).get();
            DongSp dongSp = dongSpRepo.findById(idDongSp).get();
            // Cập nhật các thuộc tính
            existingSpct.setSanPham(sanPham);
            existingSpct.setIdSp(sanPhamId);
            existingSpct.setNsx(nsx);
            existingSpct.setIdNsx(idNsx);
            existingSpct.setMauSac(mauSac);
            existingSpct.setIdMauSac(idMauSac);
            existingSpct.setDongSp(dongSp);
            existingSpct.setIdDongSp(idDongSp);
            existingSpct.setNamBh(spct.getNamBh());
            existingSpct.setMoTa(spct.getMoTa());
            existingSpct.setSoLuongTon(spct.getSoLuongTon());
            existingSpct.setGiaNhap(spct.getGiaNhap());
            existingSpct.setGiaBan(spct.getGiaBan());
            // Lưu đối tượng đã được cập nhật
            chiTietSpRepo.save(existingSpct);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/san-pham/listSpct";
    }


    @GetMapping("deletespct/{id}")
    public String delete(@PathVariable Integer id) {
        chiTietSpRepo.deleteById(id);
        return "redirect:/san-pham/listSpct";
    }

    // crud chi tiết sản phẩm ở trênnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
    @GetMapping("list")
    public String phanTrang(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 10); // Mỗi trang 5 phần tử
        Page<SanPham> sanPhams = sanPhamRepo.findAll(pageable);
        model.addAttribute("sanPham", sanPhams.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sanPhams.getTotalPages());
        model.addAttribute("sanPham2", new SanPham());
        return "sanpham/hien-thi";
    }

    @PostMapping("saveOrUpdateSanPham")
    public String add2(SanPham spC) {
        spC.setMa(generateRandomCode());
        sanPhamService.save(spC);
        return "redirect:/san-pham/list";
    }

    @GetMapping("/editSanPham/{id}")
    public String editSanPham(@PathVariable("id") Integer id, Model model) {
        Optional<SanPham> sanPhamOptional = sanPhamRepo.findById(id);
        if (sanPhamOptional.isPresent()) {
            SanPham sanPham = sanPhamOptional.get();
            model.addAttribute("sanPham1", sanPham);
            return "sanpham/editSanPham";
        }
        return "redirect:/san-pham/list";
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

    // crud sản phẩm ở trên
    private String generateRandomCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(5);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}
