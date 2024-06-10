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
@Table(name = "GioHang")
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "IdKH")
    private Integer idKh;

    @ManyToOne
    @JoinColumn(name = "IdKH" , insertable = false , updatable = false)
    private KhachHang khachHang;

    @Column(name = "IdNV")
    private Integer idNv;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgayThanhToan")
    private LocalDate ngayThanhToan;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "TinhTrang")
    private Integer tinhTrang;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "gioHang")
    private List<GioHangChiTiet> gioHangChiTiets;
}
