package com.example.Assiment_java5.repository;

import com.example.Assiment_java5.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien, Integer> {
//    List<NhanVien> findByStatus(String status);

}
