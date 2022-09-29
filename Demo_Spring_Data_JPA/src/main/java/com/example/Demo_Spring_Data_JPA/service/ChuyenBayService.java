package com.example.service;

import com.example.reponsitory.ChuyenBayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChuyenBayService {
    @Autowired
    private ChuyenBayRepository chuyenBayRepository;

    public ChuyenBayRepository getChuyenBay(){
        return  chuyenBayRepository;
    }
    public void displayAllChuyenBay() {
        chuyenBayRepository.findAll().forEach(System.out::println);
    }
}
