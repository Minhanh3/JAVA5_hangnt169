package com.example.Assiment_java5.service;

import com.example.Assiment_java5.entity.NhanVien;
import com.example.Assiment_java5.repository.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepo nhanVienRepo;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepo.findAll();
    }

    public Optional<NhanVien> getNhanVienById(Integer id) {
        return nhanVienRepo.findById(id);
    }

    public void save(NhanVien nhanVien) {
        nhanVienRepo.save(nhanVien);
    }

    public void deleteById(Integer id) {
        nhanVienRepo.deleteById(id);
    }

    public List<NhanVien> findByTenContainingIgnoreCase(String ten) {
        return nhanVienRepo.findByTenContainingIgnoreCase(ten);
    }
}
