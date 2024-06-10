package com.example.Btvn_buoi8.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sinh_vien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lop_hoc_id")
    private Long lopHocId;

    @ManyToOne
    @JoinColumn(name = "lop_hoc_id" , insertable = false , updatable = false)
    private LopHoc lopHoc;

    @Column(name = "name")
    private String name;

    @Column(name = "mssv")
    private String mssv;

    @Column(name = "dia_chi")
    private String diaChi;

}
