package com.example.Assiment_java5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ChiTietSP")
public class ChiTietSp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "IdSP")
    private Integer idSp;

    @ManyToOne
    @JoinColumn(name = "IdSP", insertable = false, updatable = false)
    @JsonIgnore
    private SanPham sanPham;

    @Column(name = "IdNsx")
    private Integer idNsx;

    @ManyToOne
    @JoinColumn(name = "IdNsx", insertable = false, updatable = false)
    @JsonIgnore
    private Nsx nsx;

    @Column(name = "IdMauSac")
    private Integer idMauSac;

    @ManyToOne
    @JoinColumn(name = "IdMauSac", insertable = false, updatable = false)
    @JsonIgnore
    private MauSac mauSac;

    @Column(name = "IdDongSP")
    private Integer idDongSp;

    @ManyToOne
    @JoinColumn(name = "IdDongSP", insertable = false, updatable = false)
    @JsonIgnore
    private DongSp dongSp;

    @Column(name = "NamBH")
    private Integer namBh;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private Double giaNhap;

    @Column(name = "GiaBan")
    private Double giaBan;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "chiTietSp")
    private Set<HoaDonChiTiet> hoaDonChiTiets;

}
