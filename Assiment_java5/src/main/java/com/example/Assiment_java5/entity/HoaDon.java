package com.example.Assiment_java5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "IdKH")
    private Integer idKh;

    @ManyToOne
    @JoinColumn(name = "IdKH", insertable = false, updatable = false)
    private KhachHang khachHang;

    @Column(name = "IdNV")
    private Integer idNv;

    @ManyToOne
    @JoinColumn(name = "IdNV", insertable = false, updatable = false)
    private NhanVien nhanVien;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgayThanhToan")
    private LocalDate ngayThanhToan;

    @Column(name = "NgayShip")
    private LocalDate ngayShip;

    @Column(name = "NgayNhan")
    private LocalDate ngayNhan;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hoaDon")
    private List<HoaDonChiTiet> hoaDonChiTiets;
}
