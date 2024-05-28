package com.example.demo16th5.service;

import com.example.demo16th5.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    List<SinhVien> list = new ArrayList<SinhVien>();

    public SinhVienService() {
        list.add(new SinhVien("ph1", "Manh", 14, "Ha noi", true));
        list.add(new SinhVien("ph2", "He", 16, "Vinh phuc", true));
        list.add(new SinhVien("ph3", "Ho", 18, "Ha noi1", false));
        list.add(new SinhVien("ph5", "Hi", 17, "Ha noi2", true));
        list.add(new SinhVien("ph6", "Hai", 19, "Ha noi3", false));
    }

    public List<SinhVien> getALL() {
        return list;
    }

    public void xoaSinhVien(String mssv) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMssv().equals(mssv)) {
                list.remove(i);
            }
        }
    }
    public void addsv(SinhVien sinhVien){
        list.add(sinhVien);
    }
    public SinhVien detailSv(String ma){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMssv().equalsIgnoreCase(ma)) {
               return list.get(i);
            }
        }
        return null ;
    }
}
