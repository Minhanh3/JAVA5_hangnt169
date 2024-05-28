package com.example.lab1.service;

import com.example.lab1.entity.CoSo;

import java.util.ArrayList;
import java.util.List;

public class CoSoService {

    private List<CoSo> coSoList = new ArrayList<>();

    public CoSoService() {
        coSoList.add(new CoSo("m1", "Hue", true, 3.2, "1"));
        coSoList.add(new CoSo("m2", "Hue2", true, 3.2, "2"));
        coSoList.add(new CoSo("m3", "Hue3", false, 3.2, "3"));
        coSoList.add(new CoSo("m4", "Hue4", true, 3.2, "1"));
        coSoList.add(new CoSo("m5", "Hue5", false, 3.2, "2"));
    }

    public List<CoSo> getAllCoSoList() {
        return coSoList;
    }

    public void delete(String ma) {
        for (int i = 0; i < coSoList.size(); i++) {
            if (coSoList.get(i).getMa().equalsIgnoreCase(ma)) {
                coSoList.remove(i);
            }
        }
    }
    public void addCoSo(CoSo cs) {
        coSoList.add(cs);
    }
    public void update(String ma){
        for (int i = 0; i < coSoList.size(); i++) {
            if (coSoList.get(i).getMa().equals(ma)) {
                coSoList.set(i, coSoList.get(i));
            }
        }
    }

    public List<CoSo> searchCoso(String ma) {
        List<CoSo> list = new ArrayList<>();
        for (CoSo coSo : coSoList){
            String ma1 = coSo.getMa();
            if (ma1.equalsIgnoreCase(ma)) {
                list.add(coSo);
            }
        }
        return list;
    }
}
