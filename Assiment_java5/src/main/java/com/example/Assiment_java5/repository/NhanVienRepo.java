package com.example.Assiment_java5.repository;

import com.example.Assiment_java5.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien, Integer> {

    // Tìm kiếm nhân viên theo tên (không phân biệt chữ hoa chữ thường và tìm kiếm một phần tên)
    @Query("SELECT nv FROM NhanVien nv WHERE LOWER(nv.ten) LIKE %:ten%")
    List<NhanVien> findByTenContainingIgnoreCase(String ten);
}
