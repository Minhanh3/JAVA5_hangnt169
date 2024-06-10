package com.example.spring01.service;

import com.example.spring01.entity.MauSac;
import com.example.spring01.repository.MauSacRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacService {

    @Autowired
    private MauSacRepo mauSacRepo;

    public List<MauSac> getAllMauSac() {
        return mauSacRepo.findAll();
    }

    public void save(MauSac mauSac) {
        mauSacRepo.save(mauSac);
    }
}
