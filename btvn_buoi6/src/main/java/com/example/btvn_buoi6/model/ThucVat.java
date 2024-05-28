package com.example.btvn_buoi6.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ThucVat {

    private Integer id;

    private String loaiCay;

    private String ten;

    private Integer tuoi;

    private boolean gioiTinh;

    private String khuVuc;

}
