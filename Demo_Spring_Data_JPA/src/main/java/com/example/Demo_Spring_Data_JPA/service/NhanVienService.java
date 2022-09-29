package com.example.service;

import com.example.reponsitory.NhanVienReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienService {

    @Autowired
    NhanVienReponsitory nhanVienReponsitory;

    public NhanVienReponsitory getNhanVien(){
        return nhanVienReponsitory;
    }
}
