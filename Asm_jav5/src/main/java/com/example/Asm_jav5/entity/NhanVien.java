package com.example.Asm_jav5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "NhanVien")
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class NhanVien {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

//    @Column(name = "IdCH")
//    private Integer idCh;

//    @Column(name = "IdCV")
//    private Integer idCv;

//    @Column(name = "IdGuiBC")
//    private Integer idGuiBc;

    @Column(name = "TrangThai")
    private Integer trangThai;


}
