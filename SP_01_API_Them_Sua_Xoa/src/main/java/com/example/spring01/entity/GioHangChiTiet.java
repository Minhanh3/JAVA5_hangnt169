package com.example.spring01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GioHangChiTiet")
public class GioHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdGioHang")
    private Integer idGioHang;

    @ManyToOne
    @JoinColumn(name = "IdGioHang" , insertable = false , updatable = false)
    private GioHang gioHang;

//    @Id
//    @Column(name = "IdChiTietSP")
//    private Integer idChiTietSp;
//
//    @ManyToOne
//    @JoinColumn(name = "IdChiTietSP", insertable = false, updatable = false)
//    private ChiTietSp chiTietSp;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Double donGia;

    @Column(name = "DonGiaKhiGiam")
    private Double donGiaKhiGiam;

}
