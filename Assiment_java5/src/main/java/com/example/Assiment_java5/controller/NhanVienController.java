package com.example.Assiment_java5.controller;

import com.example.Assiment_java5.entity.NhanVien;
import com.example.Assiment_java5.service.NhanVienService;
import com.example.Assiment_java5.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("list")
    public String hienThi(Model model, @RequestParam(value = "id", required = false) Integer id) {
        model.addAttribute("nhanVien", nhanVienService.getAllNhanVien());
        NhanVien nhanVien2;
        if (id != null) {
            Optional<NhanVien> nhanVienOpt = nhanVienService.getNhanVienById(id);
            nhanVien2 = nhanVienOpt.orElseGet(NhanVien::new);
        } else {
            nhanVien2 = new NhanVien();
        }
        model.addAttribute("nhanVien2", nhanVien2);

        return "nhanvien/hien-thi";
    }

    @PostMapping("saveOrUpdate")
    public String add(NhanVien nhanVien, Model model) {
        if (nhanVien.getMa() == null || nhanVien.getMa().isEmpty()) {
            nhanVien.setMa(generateRandomCode(5)); // Generate code if not present
        }
        nhanVienService.save(nhanVien);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String editNhanVien(@PathVariable("id") Integer id, Model model) {
        Optional<NhanVien> nhanVienOpt = nhanVienService.getNhanVienById(id);
        NhanVien nhanVien2 = nhanVienOpt.orElseGet(NhanVien::new);
        model.addAttribute("nhanVien1", nhanVien2);
        return "nhanvien/edit";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        nhanVienService.deleteById(id);
        return "redirect:/nhan-vien/list";
    }

    @GetMapping("/search")
    public String searchNhanVienByName(@RequestParam("ten") String ten, Model model) {
        List<NhanVien> result = nhanVienService.findByTenContainingIgnoreCase(ten);
        model.addAttribute("nhanVien", result);
        return "nhanvien/hien-thi :: nhan-vien-table"; // Trả về chỉ phần table để cập nhật kết quả mà không làm mới toàn bộ trang
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
