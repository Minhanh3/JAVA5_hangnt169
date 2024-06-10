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

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
    @EmbeddedId
    private HoaDonChiTietId id;

    @ManyToOne
    @MapsId("idHoaDon")
    @JoinColumn(name = "IdHoaDon", insertable = false, updatable = false)
    private HoaDon hoaDon;

    @ManyToOne
    @MapsId("idChiTietSp")
    @JoinColumn(name = "IdChiTietSP", insertable = false, updatable = false)
    private ChiTietSp chiTietSp;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Double donGia;
}
