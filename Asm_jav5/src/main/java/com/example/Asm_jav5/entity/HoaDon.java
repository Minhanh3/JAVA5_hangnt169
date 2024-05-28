package com.example.Asm_jav5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "HoaDon")
@Getter @Setter
@ToString
@NoArgsConstructor @AllArgsConstructor
public class HoaDon {
    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "IdKH")
    private Integer idKh;

    @Column(name = "IdNV")
    private Integer idNv;

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

    @Column(name = "TinhTrang")
    private Integer tinhTrang;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;


}
