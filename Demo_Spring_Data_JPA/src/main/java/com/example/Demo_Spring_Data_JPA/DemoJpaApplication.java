package com.example;

import com.example.service.ChuyenBayService;
import com.example.service.MayBayService;
import com.example.service.NhanVienService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class DemoJpaApplication {
    final ChuyenBayService chuyenBayService;
    final MayBayService mayBayService;
    final NhanVienService nhanVienService;

    public DemoJpaApplication(ChuyenBayService chuyenBayService,
                              MayBayService mayBayService, NhanVienService nhanVienService) {
        this.chuyenBayService = chuyenBayService;
        this.nhanVienService = nhanVienService;
        this.mayBayService = mayBayService;
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoJpaApplication.class, args);
    }
    @PostConstruct
    void postConstruct(){
        chuyenBayService.displayAllChuyenBay();
}
}
