package com.example.btvn_buoi5.entity;

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
@ToString
@Builder
public class GiangVien {
    private String maGV;
    private String ten;
    private int tuoi;
    private String queQuan;
}
