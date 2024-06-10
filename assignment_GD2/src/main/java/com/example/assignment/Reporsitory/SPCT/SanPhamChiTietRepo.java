package com.example.assignment.Reporsitory.SPCT;

import com.example.assignment.Entity.SPCT.ChiTietSp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamChiTietRepo extends JpaRepository<ChiTietSp, Integer> {
//    @Query("SELECT sp FROM SanPham sp WHERE sp.id = :idSP")
//    SanPham findSanPhamByIdSP(Integer idSP);
//
//    @Query("SELECT ct FROM ChiTietSpEntity ct WHERE ct.idSP = :idSP")
//    List<ChiTietSpEntity> findChiTietByIdSP(Integer idSP);
}
