package com.example.spring01.controller;

import com.example.spring01.entity.ChiTietSp;
import com.example.spring01.entity.SanPham;
import com.example.spring01.repository.ChiTietSpRepo;
import com.example.spring01.repository.SanPhamRepo;
import com.example.spring01.service.DongSpService;
import com.example.spring01.service.MauSacService;
import com.example.spring01.service.NsxService;
import com.example.spring01.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @Autowired
    private ChiTietSpRepo chiTietSpRepo;


    @GetMapping("getAllSanPham")
    public List<SanPham> getAllSanPham() {
        return sanPhamService.getAllSanPham();
    }

    @PostMapping("addSanPham")
    public ResponseEntity<String> addSanPham(@RequestBody SanPham sanPham) {
        sanPhamService.addSanPham(sanPham);
        return ResponseEntity.ok("SanPham added");
    }

    @PostMapping("addSpct")
    public ResponseEntity<String> addSpct(ChiTietSp chiTietSp) {
        sanPhamService.addspct(chiTietSp);
//        ResponseEntity.;
        return ResponseEntity.ok("SanPham chi tiet added");
    }

    @PostMapping("addSanPham2")
    public SanPham addSanPhamForChisp(SanPham sanPham) {
        return sanPhamService.save(sanPham);
    }

}
