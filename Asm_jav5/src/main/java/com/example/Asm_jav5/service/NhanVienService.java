package com.example.Asm_jav5.service;

import com.example.Asm_jav5.entity.NhanVien;
import com.example.Asm_jav5.repository.NhanVienRepo;
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

}
