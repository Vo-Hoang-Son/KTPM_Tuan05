package com.example.reponsitory;

import com.example.entity.ChungNhan;
import com.example.entity.NhanVien;
import com.jayway.jsonpath.ValueCompareException;
import com.jayway.jsonpath.internal.function.numeric.Sum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienReponsitory extends JpaRepository<NhanVien,String> {
	//Cau 3
    @Query(value = "select * from nhanvien where Luong < 10000 ", nativeQuery = true)
    public List<NhanVien> lstNhanVien();

    //Cau 8
    @Query(value = "select sum(nv.Luong)  from nhanvien nv", nativeQuery = true)
    public Long getTotalOfSalary();

    //Cau 9
    @Query(value = "select * from nhanvien nv join chungnhan c on nv.MaNV = c.MaNV\n" +
            "join maybay m on m.MaMB = c.MaMB\n" +
            "where m.Loai like '%Boeing%'\n" +
            "group by nv.MaNV, nv.Ten", nativeQuery = true)
    public List<NhanVien> getDSMaNhanVienBoeing();

    //Cau 10
    @Query(value = "select * from nhanvien nv join chungnhan c on nv.MaNV = c.MaNV\n" +
            "join maybay m on m.MaMB = c.MaMB\n" +
            "where m.MaMB = 747\n" +
            "group by nv.MaNV, nv.Ten",nativeQuery = true)
    public List<NhanVien> getDSNhanVienLaiMB747();

    //Cau 12
    @Query(value = "SELECT *\n" +
            "FROM nhanvien\n" +
            "WHERE MaNV In (select cn.MaNV from chungnhan cn inner join maybay mb on mb.MaMB = cn.MaMB where mb.Loai like '%Airbus%' or mb.Loai like '%Boeing%')",nativeQuery = true)
    public List<NhanVien> getDSNhanVienLaiMBAirBusVaBoing();

    //Cau 15
    @Query(value = "select count(*) from nhanvien join chungnhan c on nhanvien.MaNV = c.MaNV\n" +
            "join maybay m on m.MaMB = c.MaMB\n" +
            "where m.Loai = :loai",nativeQuery = true)
    public int getTongSoPhiCongLaiLoaiMayBay(String loai);

    //Cau 22
    @Query(value = "select nv.MaNV from nhanvien nv join chungnhan c on nv.MaNV = c.MaNV\n" +
            "join maybay m on m.MaMB = c.MaMB\n" +
            "group by nv.MaNV\n" +
            "having count(m.Loai) = 3",nativeQuery = true)
    public List<String> getDSMaNVChiLaiDuoc3LoaiMB();

    //Cau 23
    @Query(value = "select nv.MaNV, max(TamBay) from nhanvien nv join chungnhan c on nv.MaNV = c.MaNV\n" +
            "                                join maybay m on m.MaMB = c.MaMB\n" +
            "group by nv.MaNV\n" +
            "having count(m.Loai) >= 3",nativeQuery = true)
    public List<Object[]> getDSNhanVienLaiHon3LoaiMB();

    //Cau 24
    @Query(value = "select nv.MaNV, count(Loai) from nhanvien nv join chungnhan c on nv.MaNV = c.MaNV\n" +
            "                                join maybay m on m.MaMB = c.MaMB\n" +
            "group by nv.MaNV", nativeQuery = true)
    public List<Object[]> getDSMaNVVaTongLoaiMB();

    //Cau 25
    @Query(value = "select  MaNV,Ten from nhanvien \n" +
            "where MaNV not in (select MaNV from chungnhan)",nativeQuery = true)
    public List<Object[]> getDSNhanVienKhongPhaiPhiCong();

    //Cau 26
    @Query(value = "select MaNV,Ten,Luong\n" +
            "from nhanvien where Luong in (select MAX(Luong) from nhanvien)",nativeQuery = true)
    public List<Object[]> getDSMaNVCoLuongCaoNhat();

    //Cau 27
    @Query(value = "select SUM(Luong) from nhanvien\n" +
            "where MaNV in (select MaNV from chungnhan)",nativeQuery = true)
    public int getTongLuongPhiCong();
}