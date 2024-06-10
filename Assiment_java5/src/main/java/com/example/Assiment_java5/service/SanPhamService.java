package com.example.Assiment_java5.service;

import com.example.Assiment_java5.entity.ChiTietSp;
import com.example.Assiment_java5.entity.DongSp;
import com.example.Assiment_java5.entity.MauSac;
import com.example.Assiment_java5.entity.Nsx;
import com.example.Assiment_java5.entity.SanPham;
import com.example.Assiment_java5.repository.ChiTietSpRepo;
import com.example.Assiment_java5.repository.DongSpRepo;
import com.example.Assiment_java5.repository.MauSacRepo;
import com.example.Assiment_java5.repository.NSXRepo;
import com.example.Assiment_java5.repository.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @Autowired
    private ChiTietSpRepo chiTietSpRepo;

    @Autowired
    private DongSpRepo dongSpRepo;

    @Autowired
    private MauSacRepo mauSacRepo;

    @Autowired
    private NSXRepo nsxRepo;

    public List<SanPham> getAllSanPham() {
        return sanPhamRepo.findAll();
    }

    public ChiTietSp getChiTietSpById(Integer id) {
        return chiTietSpRepo.findById(id).orElse(null);
    }

    public SanPham save(SanPham sanPham) {
        try {
            sanPhamRepo.save(sanPham);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public ChiTietSp addspct(ChiTietSp chiTietSp, Integer sanPhamId,
                             Integer idNsx, Integer idMauSac, Integer idDongSp) {
        SanPham sanPhamEntity = sanPhamRepo.findById(sanPhamId).orElse(null);
        Nsx nsx = nsxRepo.findById(idNsx).orElse(null);
        MauSac mauSacEntity = mauSacRepo.findById(idMauSac).orElse(null);
        DongSp dongSp = dongSpRepo.findById(idDongSp).orElse(null);
        chiTietSp.setIdSp(sanPhamId);
        chiTietSp.setDongSp(dongSp);
        chiTietSp.setMauSac(mauSacEntity);
        chiTietSp.setNsx(nsx);
        chiTietSp.setSanPham(sanPhamEntity);
        chiTietSpRepo.save(chiTietSp);
        return chiTietSp;
    }

    public void update() {

    }
}
