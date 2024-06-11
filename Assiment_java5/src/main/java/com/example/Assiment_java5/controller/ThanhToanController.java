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
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("thanhtoan")
public class ThanhToanController {

    @Autowired
    private HoaDonChiTietRepo hoaDonRepo;

    @GetMapping("/thanh-toan")
    public String thanhToan(Model model) {
        // Lấy dữ liệu lịch sử hóa đơn từ cơ sở dữ liệu và thêm vào model
        List<HoaDonChiTiet> lichSuHoaDon = hoaDonRepo.findAll();
        model.addAttribute("lichSuHoaDon", lichSuHoaDon);
        // Thêm thông báo thanh toán thành công vào model
        model.addAttribute("thongBao", "Thanh toán thành công!");

        return "banhang/thanh-toan";
    }
}
