package com.example.Assiment_java5.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MauSac")
public class MauSac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "mauSac")
    @JsonIgnoreProperties
    private List<ChiTietSp> chiTietSps;
}
