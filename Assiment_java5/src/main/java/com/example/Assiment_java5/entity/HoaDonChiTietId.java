package com.example.Assiment_java5.entity;

import java.io.Serializable;
import java.util.Objects;

public class HoaDonChiTietId implements Serializable {

    private Integer idHoaDon;
    private Integer idChiTietSp;

    public HoaDonChiTietId() {
    }

    public HoaDonChiTietId(Integer idHoaDon, Integer idChiTietSp) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSp = idChiTietSp;
    }

    // Getters and setters
    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Integer getIdChiTietSp() {
        return idChiTietSp;
    }

    public void setIdChiTietSp(Integer idChiTietSp) {
        this.idChiTietSp = idChiTietSp;
    }

    // hashCode and equals methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoaDonChiTietId that = (HoaDonChiTietId) o;
        return Objects.equals(idHoaDon, that.idHoaDon) && Objects.equals(idChiTietSp, that.idChiTietSp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHoaDon, idChiTietSp);
    }
}
