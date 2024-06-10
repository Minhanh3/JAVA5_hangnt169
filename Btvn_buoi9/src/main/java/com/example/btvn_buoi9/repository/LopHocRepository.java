package com.example.btvn_buoi9.repository;

import com.example.btvn_buoi9.entity.LopHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopHocRepository extends JpaRepository<LopHoc, Long> {
}
