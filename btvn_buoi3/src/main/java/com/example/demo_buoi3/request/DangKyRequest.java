package com.example.demo_buoi3.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DangKyRequest {
    @Pattern(regexp = "^(?!HE130461$).*$", message = "MSSV phải khác 'HE130461'")
    @NotEmpty(message = "ma so sinh vien khong duoc trong")
    private String mssv;

    @NotEmpty(message = "hoVaTen khong duoc trong")
    private String hoVaTen;

    @Min(value = 18, message = "Tuoi phai lon hon 18 hoac bang 18")
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
