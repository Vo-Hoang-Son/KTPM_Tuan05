package com.example.service;

import com.example.reponsitory.MayBayReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MayBayService {

    @Autowired
    private MayBayReponsitory mayBayReponsitory;

    public MayBayReponsitory getMayBay() {
        return mayBayReponsitory;
    }
    public void displayMayBayTamBayLonHon10000(){
        System.out.println("May bay co tam bay lon hon 100000");
        mayBayReponsitory.lstMayBayCoTamBayLonHon10000()
                .forEach(System.out::println);
    }

}
