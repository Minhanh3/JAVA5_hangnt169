package com.example.Assiment_java5.controller;

import com.example.Assiment_java5.entity.ChiTietSp;
import com.example.Assiment_java5.entity.HoaDon;
import com.example.Assiment_java5.entity.HoaDonChiTiet;
import com.example.Assiment_java5.entity.HoaDonChiTietId;
import com.example.Assiment_java5.repository.ChiTietSpRepo;
import com.example.Assiment_java5.repository.HoaDonChiTietRepo;
import com.example.Assiment_java5.repository.HoaDonRepo;
import com.example.Assiment_java5.repository.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("ban-hang")
public class BanHangController {

    @Autowired
    private HoaDonRepo hoaDonRepo;

    @Autowired
    private HoaDonChiTietRepo hoaDonChiTietRepo;

    @Autowired
    private ChiTietSpRepo chiTietSpRepo;

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @GetMapping("list")
    public String hienThi(Model model) {
        model.addAttribute("hoaDon", hoaDonRepo.findAll());
        model.addAttribute("hoaDonChiTiet", hoaDonChiTietRepo.findAll());
        return "banhang/TrangBanHang";
    }

    @PostMapping("addHoaDon")
    public String addHoaDon(HoaDon hoaDon) {
        hoaDon.setIdNv(1);
        hoaDon.setMa(generateRandomCode(5));
        hoaDon.setNgayTao(LocalDate.now());
        hoaDon.setNgayThanhToan(LocalDate.now());
        hoaDon.setNgayShip(LocalDate.now());
        hoaDon.setNgayNhan(LocalDate.now());
        hoaDonRepo.save(hoaDon);
        return "redirect:/ban-hang/list";
    }

    @GetMapping("trangAddCtHoaDon/{hoaDonId}")
    public String trangCTHd(@PathVariable Integer hoaDonId, Model model) {
        model.addAttribute("hoaDonId", hoaDonId);
        model.addAttribute("sanPham", sanPhamRepo.findAll());
        return "banhang/trangAddCtHoaDon"; // Đảm bảo đường dẫn và tên tệp chính xác ở đây
    }

    @PostMapping("addHoaDonChiTiet")
    public String addHoaDonChiTiet(@RequestParam Integer hoaDonId,
                                   @RequestParam Integer sanPhamId,
                                   @RequestParam Integer soLuong) {
        Optional<HoaDon> optionalHoaDon = hoaDonRepo.findById(hoaDonId);
        if (optionalHoaDon.isPresent()) {
            HoaDon hoaDon = optionalHoaDon.get();
            Optional<ChiTietSp> chiTietSpOptional = chiTietSpRepo.findById(sanPhamId);
            if (chiTietSpOptional.isPresent()) {
                ChiTietSp chiTietSp = chiTietSpOptional.get();
                HoaDonChiTietId hoaDonChiTietId = new HoaDonChiTietId(hoaDonId, chiTietSp.getId());
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setId(hoaDonChiTietId);
                hoaDonChiTiet.setHoaDon(hoaDon);
                hoaDonChiTiet.setChiTietSp(chiTietSp);
                hoaDonChiTiet.setSoLuong(soLuong);
                hoaDonChiTiet.setDonGia(chiTietSp.getGiaBan() * soLuong);
                chiTietSp.setSoLuongTon(chiTietSp.getSoLuongTon() - soLuong);
                chiTietSpRepo.save(chiTietSp);
                hoaDonChiTietRepo.save(hoaDonChiTiet);
            }
        }
        return "redirect:/ban-hang/list";
    }

    // Utility method to generate a random 5-character alphanumeric code
    private String generateRandomCode(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder code = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            code.append(chars.charAt(random.nextInt(chars.length())));
        }
        return code.toString();
    }
}
