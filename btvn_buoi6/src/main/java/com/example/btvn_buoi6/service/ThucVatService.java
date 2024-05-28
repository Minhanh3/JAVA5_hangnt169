package com.example.btvn_buoi6.service;

import com.example.btvn_buoi6.model.ThucVat;

import java.util.ArrayList;
import java.util.List;

public class ThucVatService {
    List<ThucVat> thucVatList = new ArrayList<>();

    public ThucVatService() {
        thucVatList.add(new ThucVat(1 , "Cỏ" , "Chanh" , 22 , true , "đá"));
        thucVatList.add(new ThucVat(2 , "Cỏ" , "Dưa" , 22 , true , "đá"));
        thucVatList.add(new ThucVat(3 , "Cỏ" , "Gạo" , 22 , true , "đá"));
        thucVatList.add(new ThucVat(4 , "Cỏ" , "Hun" , 22 , true , "đá"));
        thucVatList.add(new ThucVat(5 , "Cỏ" , "Quất" , 22 , true , "đá"));
    }
    public List<ThucVat> getAllThucVat() {
        return thucVatList;
    }
    public void addThucVat(ThucVat thucVat){
        thucVatList.add(thucVat);
    }
    public void remove(Integer id){
        for (int i = 0; i < thucVatList.size(); i++) {
            if (thucVatList.get(i).getId().equals(id)) {
                thucVatList.remove(i);
            }
        }
    }

    public List<ThucVat> searchThucVat(String name) {
        List<ThucVat> list = new ArrayList<>();
        for (ThucVat thucVat : thucVatList) {
            String ten = thucVat.getTen();
            if (ten.equalsIgnoreCase(name)) {
                list.add(thucVat);
            }
        }
        return list;
    }
    public void updateThucVat(Integer id){
        for (int i = 0; i < thucVatList.size(); i++) {
            if (thucVatList.get(i).getId().equals(id)) {
                thucVatList.set(i, thucVatList.get(i+1));
            }
        }
    }
}
