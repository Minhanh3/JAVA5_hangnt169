package com.example.spring01.service;

import com.example.spring01.entity.NhanVien;
import com.example.spring01.repository.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepo nhanVienRepo;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepo.findAll();
    }

    public void save(NhanVien nhanVien) {
        nhanVienRepo.save(nhanVien);
    }
}
