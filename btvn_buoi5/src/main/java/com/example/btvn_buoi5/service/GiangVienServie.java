package com.example.btvn_buoi5.service;

import com.example.btvn_buoi5.entity.GiangVien;

import java.util.ArrayList;
import java.util.List;

public class GiangVienServie {

    private List<GiangVien> giangVienList = new ArrayList<>();

    public GiangVienServie() {
        giangVienList.add(new GiangVien("gv1", "Giang", 32, "ha noi"));
        giangVienList.add(new GiangVien("gv2", "Ha", 22, "ha noi"));
        giangVienList.add(new GiangVien("gv3", "Hue", 12, "ha noi"));
        giangVienList.add(new GiangVien("gv4", "Hang", 22, "ha noi"));
        giangVienList.add(new GiangVien("gv5", "Nam", 21, "ha noi"));
    }

    public List<GiangVien> getAll() {
        return giangVienList;
    }

    public void add(GiangVien giangVien) {
        giangVienList.add(giangVien);
    }

    public GiangVien detail(String ma) {
        for (int i = 0; i < giangVienList.size(); i++) {
            if (giangVienList.get(i).getMaGV().equalsIgnoreCase(ma)) {
                return giangVienList.get(i);
            }
        }
        return null;
    }

    public void delete(String ma) {
        for (int i = 0; i < giangVienList.size(); i++) {
            if (giangVienList.get(i).getMaGV().equalsIgnoreCase(ma)) {
                giangVienList.remove(i);
            }
        }
    }

    public List<GiangVien> searchname(String ten) {
        List<GiangVien> list = new ArrayList<>();
        for (GiangVien giangVien : giangVienList) {
            String name = giangVien.getTen();
            if (name.equalsIgnoreCase(ten)) {
                list.add(giangVien);
            }
        }
        if (list.isEmpty()) {
            System.out.println("Null");
        }
        return list;
    }

}
