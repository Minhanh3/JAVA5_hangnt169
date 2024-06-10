package com.example.spring01.service;

import com.example.spring01.entity.ChiTietSp;
import com.example.spring01.entity.DongSp;
import com.example.spring01.entity.MauSac;
import com.example.spring01.entity.Nsx;
import com.example.spring01.entity.SanPham;
import com.example.spring01.repository.ChiTietSpRepo;
import com.example.spring01.repository.DongSpRepo;
import com.example.spring01.repository.MauSacRepo;
import com.example.spring01.repository.NSXRepo;
import com.example.spring01.repository.SanPhamRepo;
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

    public SanPham addSanPham(SanPham sanPham) {
        return sanPhamRepo.save(sanPham);
    }

    public SanPham save(SanPham sanPham) {
        sanPhamRepo.save(sanPham);
        try {
            for (ChiTietSp chiTietSp : sanPham.getChiTietSps()) {
                Optional<MauSac> mauSac = mauSacRepo.findById(chiTietSp.getIdMauSac());
                Optional<DongSp> dongSp = dongSpRepo.findById(chiTietSp.getIdDongSp());
                Optional<Nsx> nsx = nsxRepo.findById(chiTietSp.getIdNsx());
                if (mauSac.isPresent() && dongSp.isPresent() && nsx.isPresent()) {
                    chiTietSp.setIdSp(sanPham.getId());
                    chiTietSp.setSanPham(sanPham);
                    chiTietSp.setIdMauSac(mauSac.get().getId());
                    chiTietSp.setMauSac(mauSac.get());
                    chiTietSp.setIdDongSp(dongSp.get().getId());
                    chiTietSp.setDongSp(dongSp.get());
                    chiTietSp.setIdNsx(nsx.get().getId());
                    chiTietSp.setNsx(nsx.get());
                    chiTietSpRepo.save(chiTietSp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public ChiTietSp addspct(ChiTietSp chiTietSp) {
        if (chiTietSp == null) {
            List<ChiTietSp> chiTietSps = chiTietSpRepo.findAll();
            System.out.println(chiTietSps);
            throw new IllegalArgumentException("Lỗi chiTietSp");
        }
        SanPham sanPham = sanPhamRepo.findById(chiTietSp.getIdSp()).orElse(null);
        MauSac mauSac = mauSacRepo.findById(chiTietSp.getIdMauSac()).orElse(null);
        Nsx nsx = nsxRepo.findById(chiTietSp.getIdNsx()).orElse(null);
        DongSp dongSp = dongSpRepo.findById(chiTietSp.getIdDongSp()).orElse(null);
        chiTietSp.setSanPham(sanPham);
        chiTietSp.setMauSac(mauSac);
        chiTietSp.setNsx(nsx);
        chiTietSp.setDongSp(dongSp);
        chiTietSpRepo.save(chiTietSp);

        return chiTietSp;
    }
}
