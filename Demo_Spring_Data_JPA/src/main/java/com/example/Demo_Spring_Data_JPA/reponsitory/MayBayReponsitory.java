package com.example.reponsitory;

import com.example.entity.MayBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MayBayReponsitory extends JpaRepository<MayBay,Integer> {
	//Cau 2
    @Query(value = "select * from maybay where TamBay > 10000", nativeQuery = true)
    public List<MayBay> lstMayBayCoTamBayLonHon10000();

    //Cau 7
    @Query(value = "select count(*) as soluong from maybay where Loai like '%Boeing%'",nativeQuery = true)
    public Integer tongSoMayBayBoing();

    //Cau 11
    @Query(value = "select * from maybay m join chungnhan c on m.MaMB = c.MaMB\n" +
            "                          join nhanvien nv on nv.MaNV = c.MaNV\n" +
            "where nv.Ten like '%Nguyen%'",nativeQuery = true)
    public List<MayBay> getDSMMayBayDoPhiCongHoNguyenLai();

    //Cau 13
    @Query(value = "select * from maybay where TamBay >= 11979",nativeQuery = true)
    public List<MayBay> lstLoaiMayBayBayDuocChuyen280();

    //Cau 16
    @Query(value = "select Loai from maybay\n" +
            "where exists(select * from chungnhan cn join maybay mb on mb.MaMB = cn.MaMB)",nativeQuery = true)
    public List<String> loaiMayBayCoPhiCongLai();



}
