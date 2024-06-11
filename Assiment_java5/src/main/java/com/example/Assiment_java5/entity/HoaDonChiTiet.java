package com.example.Assiment_java5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHoaDonChiTiet")
    private Integer idHoaDonChiTiet;

    @Column(name = "IdHoaDon")
    private Integer idHoaDon;

    @ManyToOne
    @JoinColumn(name = "IdHoaDon", insertable = false, updatable = false)
    private HoaDon hoaDon;

    @Column(name = "IdChiTietSP")
    private Integer idChiTietSP;

    @ManyToOne
    @JoinColumn(name = "IdChiTietSP", insertable = false, updatable = false)
    private ChiTietSp chiTietSp;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Double donGia;
}
