package com.example.ASM_JAVA5.service;

import com.example.ASM_JAVA5.entity.NhanVien;
import com.example.ASM_JAVA5.repository.NhanVienRepo;
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
