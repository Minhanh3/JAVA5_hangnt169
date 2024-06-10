package com.example.btvn_buoi9.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lop_hoc_id")
    private Long lopHocId;

    @ManyToOne
    @JoinColumn(name = "lop_hoc_id" , insertable = false , updatable = false)
    @JsonIgnore
    private LopHoc lopHoc;

    @Column(name = "name")
    private String name;

    @Column(name = "mssv")
    private String mssv;

    @Column(name = "dia_chi")
    private String diaChi;

}
