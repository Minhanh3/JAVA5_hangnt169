package com.example.Asm_jav5.repository;

import com.example.Asm_jav5.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien, Integer> {
}
