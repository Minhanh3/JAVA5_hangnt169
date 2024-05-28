package com.example.btvn_buoi4.service;

import com.example.btvn_buoi4.entity.GiangVien;

import java.util.ArrayList;
import java.util.List;

public class GiangVienService {
    private List<GiangVien> giangVienList = new ArrayList<>();

    public GiangVienService() {
        giangVienList.add(new GiangVien("1", "PH123", "Manh", 12, true, "Ha noi"));
        giangVienList.add(new GiangVien("2", "PH1234", "ManhM", 13, true, "Ha noi"));
        giangVienList.add(new GiangVien("3", "PH1236", "ManhHu", 12, false, "Ha noi"));
        giangVienList.add(new GiangVien("4", "PH1236", "ManhHuP", 11, false, "Ha noi"));
        giangVienList.add(new GiangVien("5", "PH1236", "ManhHuK", 10, true, "Ha noi"));
    }

    public List<GiangVien> getAll() {
        return giangVienList;
    }

    public void xoaGiangVien(String id) {
        for (int i = 0; i < giangVienList.size(); i++) {
            if (giangVienList.get(i).getId().equals(id)) {
                giangVienList.remove(i);
            }
        }
    }

    public List<GiangVien> searchName(String name) {
        List<GiangVien> list = new ArrayList<>();
        for (GiangVien giangVien : giangVienList) {
            String ten = giangVien.getTen();
            if (ten.contains(name)) {
                list.add(giangVien);
            }
        }
        if (list.isEmpty()) {
            System.out.println("Khong co trong danh sach");
        }
        return list;
    }

    public List<GiangVien> giangvienNu() {
        List<GiangVien> list = new ArrayList<>();
        for (GiangVien giangVien : giangVienList) {
            if (!giangVien.isGioiTinh()) {
                list.add(giangVien);
            }
        }
        if (list.isEmpty()) {
            System.out.println("Khong co trong danh sach");
        }
        return list;
    }
}
