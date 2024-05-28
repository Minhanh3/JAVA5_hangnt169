package com.example.lab1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CoSo {

    private String ma;

    private String ten;

    private boolean trangThai;

    private Double dienTich;

    private String loai;

}
