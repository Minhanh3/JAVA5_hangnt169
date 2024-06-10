package com.example.Assiment_java5.service;

import com.example.Assiment_java5.entity.Nsx;
import com.example.Assiment_java5.repository.NSXRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NsxService {

    @Autowired
    private NSXRepo nsxRepo;

    public List<Nsx> getAllNsx() {
        return nsxRepo.findAll();
    }

    public void save(Nsx nsx){
        nsxRepo.save(nsx);
    };
}
