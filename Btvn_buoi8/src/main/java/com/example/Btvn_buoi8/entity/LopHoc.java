package com.example.Btvn_buoi8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lop_hoc")
public class LopHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dia_diem_lop_hoc")
    private String diaDiemLopHoc;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "lopHoc")
    private List<SinhVien> sinhViens;
}
