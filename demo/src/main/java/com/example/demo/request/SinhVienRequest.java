package com.example.demo.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SinhVienRequest {
    @NotEmpty(message = "ma so sinh vien khong duoc trong")
    private String MSSV;

    @NotEmpty(message = "ma so sinh vien khong duoc trong")
    private String hoVaTen;

    @Min(8)
    @NotNull
    @Pattern(regexp = "/^[a-zA-Z]*$/")
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
