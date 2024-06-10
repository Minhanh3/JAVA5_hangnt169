package com.example.ASM_JAVA5.service;

import com.example.ASM_JAVA5.entity.ChiTietSp;
import com.example.ASM_JAVA5.entity.SanPham;
import com.example.ASM_JAVA5.repository.ChiTietSpRepo;
import com.example.ASM_JAVA5.repository.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietSpService {

    @Autowired
    private ChiTietSpRepo chiTietSpRepo;

    public List<ChiTietSp> getAllChiTietSp() {
        return chiTietSpRepo.findAll();
    }

}
