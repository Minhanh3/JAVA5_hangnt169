package com.example.btnvn_buoi3.Requiest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SinhVienRequi {
    /*
     */
    @NotEmpty(message = "ma so sinh vien khong duoc trong")
    private String mssv;

    @NotEmpty(message = "ma so sinh vien khong duoc trong")
    private String hoVaTen;

    @Min(4)
    @NotNull
    private int tuoi;

    @NotEmpty(message = "gioiTinh khong duoc trong")
    private String gioiTinh;

    @NotEmpty(message = "kyHoc khong duoc trong")
    private String kyHoc;

    @NotEmpty(message = "nganhHoc khong duoc trong")
    private String nganhHoc;

    @NotEmpty(message = "ma so sinh vien khong duoc trong")
    private String queQuan;

    @NotEmpty(message = "ma so sinh vien khong duoc trong")
    private String matKhau;

    @NotEmpty(message = "ma so sinh vien khong duoc trong")
    private String cfMatKhau;

}
