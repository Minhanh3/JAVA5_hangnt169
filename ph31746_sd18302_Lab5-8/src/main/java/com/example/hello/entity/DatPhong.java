package com.example.hello.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dat_phong")
public class DatPhong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "khach_hang_id")
    private Integer khachHangId;

    @ManyToOne
    @JoinColumn(name = "khach_hang_id" , insertable = false , updatable = false)
    private KhachHang khachHang;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "ngay_gio_dat")
    private LocalDate ngayGioDat;

    @Column(name = "so_luong_khach")
    private Integer soLuongKhach;

    @Column(name = "so_luong_phong_dat")
    private Integer soLuongPhongDat;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @Column(name = "ngay_chinh_sua")
    private LocalDate ngayChinhSua;

}
