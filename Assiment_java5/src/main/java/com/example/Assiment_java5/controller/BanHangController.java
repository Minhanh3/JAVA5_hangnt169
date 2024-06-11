package com.example.Assiment_java5.controller;

import com.example.Assiment_java5.entity.ChiTietSp;
import com.example.Assiment_java5.entity.HoaDon;
import com.example.Assiment_java5.entity.HoaDonChiTiet;
import com.example.Assiment_java5.repository.ChiTietSpRepo;
import com.example.Assiment_java5.repository.HoaDonChiTietRepo;
import com.example.Assiment_java5.repository.HoaDonRepo;
import com.example.Assiment_java5.repository.KhachHangRepo;
import com.example.Assiment_java5.repository.NhanVienRepo;
import com.example.Assiment_java5.repository.SanPhamRepo;
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

    @Autowired
    private KhachHangRepo khachHangRepo;

    @Autowired
    private NhanVienRepo nhanVienRepo;

    @GetMapping("list")
    public String hienThi(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 7; // Số lượng hóa đơn trên mỗi trang
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<HoaDon> hoaDons = hoaDonRepo.findAll(pageable);
        model.addAttribute("hoaDon", hoaDons.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", hoaDons.getTotalPages());
        model.addAttribute("hoaDonCT2", hoaDonChiTietRepo.findAll());
        model.addAttribute("nhanViens", nhanVienRepo.findAll());
        model.addAttribute("khachHangs", khachHangRepo.findAll());
        model.addAttribute("chiTietSps", chiTietSpRepo.findAll());
        model.addAttribute("hoaDonNew", new HoaDon());
        return "banhang/TrangBanHang";
    }

    @PostMapping("addHoaDon")
    public String addHoaDon(@RequestParam Integer idNhanVien,
                            @RequestParam Integer idKhachHang,
                            Model model) {
        try {
            HoaDon hoaDon = new HoaDon();
            hoaDon.setIdNv(idNhanVien);
            hoaDon.setIdKh(idKhachHang);
            hoaDon.setMa(generateRandomCode(5));
            hoaDon.setNgayTao(LocalDate.now());
            hoaDon.setNgayThanhToan(LocalDate.now());
            hoaDon.setNgayShip(LocalDate.now());
            hoaDon.setNgayNhan(LocalDate.now());
            hoaDonRepo.save(hoaDon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/ban-hang/list";
    }

// trang add hóa đơn ở trên

    @GetMapping("trangAddCtHoaDon/{hoaDonId}")
    public String trangCTHd(@PathVariable Integer hoaDonId, Model model) {
        model.addAttribute("hoaDonId", hoaDonId);
        model.addAttribute("sanPham", sanPhamRepo.findAll());
        model.addAttribute("hoaDonChiTiet", new HoaDonChiTiet()); // Initialize hoaDonChiTiet here
        model.addAttribute("sanPhamCt", chiTietSpRepo.findAll());
        return "banhang/trangAddCtHoaDon";
    }

    @PostMapping("addHoaDonChiTiet")
    public String addHoaDonChiTiet(@RequestParam Integer hoaDonId,
                                   @RequestParam Integer sanPhamCTId,
                                   @RequestParam Integer soLuong) {
        try {
            Optional<HoaDon> optionalHoaDon = hoaDonRepo.findById(hoaDonId);
            Optional<ChiTietSp> chiTietSpOptional = chiTietSpRepo.findById(sanPhamCTId);
            if (optionalHoaDon.isPresent() && chiTietSpOptional.isPresent()) {
                HoaDon hoaDon = optionalHoaDon.get();
                ChiTietSp chiTietSp = chiTietSpOptional.get();
                if (soLuong > chiTietSp.getSoLuongTon()) {
                    return "redirect:/ban-hang/list"; // Chuyển hướng tới trang lỗi
                }
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setHoaDon(hoaDon);
                hoaDonChiTiet.setIdHoaDon(hoaDon.getId());
                hoaDonChiTiet.setChiTietSp(chiTietSp);
                hoaDonChiTiet.setIdChiTietSP(chiTietSp.getId());
                hoaDonChiTiet.setSoLuong(soLuong);
                hoaDonChiTiet.setDonGia(chiTietSp.getGiaBan() * soLuong);
                // Update soLuongTon in ChiTietSp
                chiTietSp.setSoLuongTon(chiTietSp.getSoLuongTon() - soLuong);
                // Save changes
                chiTietSpRepo.save(chiTietSp);
                hoaDonChiTietRepo.save(hoaDonChiTiet);
            } else {
                throw new Exception("Không tìm thấy HoaDon hoặc ChiTietSp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/ban-hang/list";
        }
        return "redirect:/ban-hang/list";
    }
    @GetMapping("delete/{id}")
    public String deleteHoaDonChiTiet(@PathVariable Integer hoaDonId) {
        chiTietSpRepo.deleteById(hoaDonId);
        return "redirect:/ban-hang/list";
    }

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
