package com.example.ASM_JAVA5.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "IdCH")
    private Integer idCh;

    @Column(name = "IdCV")
    private Integer idCv;

//    @Column(name = "IdGuiBC")
//    private Integer idGuiBc;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "nhanVien")
    @JsonIgnoreProperties
    private List<HoaDon> hoaDons;

//    @OneToMany(fetch = FetchType.LAZY , mappedBy = "nhanVien")
//    @JsonIgnoreProperties
//    private List<GioHang> gioHangs;
}
