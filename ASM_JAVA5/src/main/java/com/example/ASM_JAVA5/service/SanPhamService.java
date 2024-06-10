package com.example.ASM_JAVA5.service;

import com.example.ASM_JAVA5.entity.ChiTietSp;
import com.example.ASM_JAVA5.entity.DongSp;
import com.example.ASM_JAVA5.entity.MauSac;
import com.example.ASM_JAVA5.entity.NhanVien;
import com.example.ASM_JAVA5.entity.Nsx;
import com.example.ASM_JAVA5.entity.SanPham;
import com.example.ASM_JAVA5.repository.ChiTietSpRepo;
import com.example.ASM_JAVA5.repository.DongSpRepo;
import com.example.ASM_JAVA5.repository.MauSacRepo;
import com.example.ASM_JAVA5.repository.NSXRepo;
import com.example.ASM_JAVA5.repository.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @Autowired
    private ChiTietSpRepo chiTietSpRepo;

    @Autowired
    private DongSpRepo dongSpRepo ;

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

    public SanPham add(SanPham sanPham) {
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return sanPham;
    }

}
