package com.example.demo16th5.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SinhVien {
    // mssv-String,ten-String,tuoi-int,diaChi-String,gioiTinh-boolean
    private String mssv;

    private String ten;

    private int tuoi;

    private String diaChi;

    private boolean gioiTinh;
}
