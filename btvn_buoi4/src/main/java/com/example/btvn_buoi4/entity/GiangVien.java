package com.example.btvn_buoi4.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
@AllArgsConstructor @NoArgsConstructor
@Builder

public class GiangVien {
    private String id ;
    private String ma ;
    private String ten ;
    private int tuoi ;
    private boolean gioiTinh ;
    private String diaChi ;
}
