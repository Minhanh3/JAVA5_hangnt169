package com.example.btnvn_buoi3.Requiest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DangKyRequest {
    // check bao nhieu ky tự
//    @Size(min = 5)
    @NotEmpty(message = "Ten khong duoc trống")
    private String hoVaTen;
//    @Pattern(regexp = "") // check chữ
//    @NotEmpty(message = "tuoi khong duoc trống")
    @Min(8)
    @NotNull
//    @Pattern(regexp = "/^[a-zA-Z]*$/")
    private int tuoi;

    @NotEmpty(message = "nganhHoc khong duoc trống")
    private String nganhHoc;

    @NotEmpty(message = "queQuan khong duoc trống")
    private String queQuan;

    @NotEmpty(message = "matKhau khong duoc trống")
    private String matKhau;

    @NotEmpty(message = "cfMatKhau khong duoc trống")
    private String cfMatKhau;
}
