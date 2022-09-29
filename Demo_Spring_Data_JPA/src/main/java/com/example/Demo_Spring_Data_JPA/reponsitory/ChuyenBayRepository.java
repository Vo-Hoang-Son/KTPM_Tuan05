package com.example.reponsitory;

import com.example.entity.ChuyenBay;
import org.hibernate.engine.internal.ImmutableEntityEntry;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface ChuyenBayRepository extends JpaRepository<ChuyenBay,String> {
	//Cau 1
    @Query(value = "SELECT * FROM chuyenbay where GaDen = DAD", nativeQuery = true)
    public List<ChuyenBay> getDSChuyenBayDenDaLat();

    //Cau 4
    @Query(value = "select * from chuyenbay where DoDai < 10000 and DoDai > 8000", nativeQuery = true)
    public List<ChuyenBay> getDSChuyenBayTheoDoDai_8000_10000km();

    //Cau 5
    @Query(value = "select * from chuyenbay where (GaDi = 'SGN' and GaDen = 'BMV')",nativeQuery = true)
    public List<ChuyenBay> getDSChuyenBayXuatPhatTuSaiGonDiBuonMeThuoc();

    //Cau 6
    @Query(value = "select count(*) from chuyenbay where GaDi = 'SGN'",nativeQuery = true)
    public int getSoChuyenBayXuatPhatTuSG();

    //Cau 14
    @Query(value = "select * from chuyenbay\n" +
            "where (select TamBay from maybay where Loai = 'Airbus A320') > DoDai", nativeQuery = true)
    public List<ChuyenBay> getDSChuyenBayDuocBayBoiAirbus320();

    //Cau 17
    @Query(value = "select * from chuyenbay\n" +
            "where GaDi in (select GaDen from chuyenbay)\n" +
            "  and GaDen in (select GaDi from chuyenbay)", nativeQuery = true)
    public List<ChuyenBay> getDSChuyenBayDiThang();

    //Cau 20
    @Query(value = "select * from chuyenbay\n" +
            "where GioDi < '12:00'", nativeQuery = true)
    public List<ChuyenBay> lstChuyenBayKhoiHanhTruoc12h();

    @Query(value = "select GaDi from chuyenbay group by GaDi",nativeQuery = true)
    public List<String> getGaDi();

    @Query(value = "select count(*) from chuyenbay\n" +
            "group by GaDi",nativeQuery = true)
    public List<Integer> lstSoChuyenBayTheoGaDi();

    @Query(value = "select SUM(ChiPhi) from chuyenbay\n" +
            "group by GaDi",nativeQuery = true)
    public List<Integer> lstTongChiPhi();

    @Query(value = "select * from chuyenbay\n" +
            "where GioDi < '12:00' group by GaDi", nativeQuery = true)
    public List<ChuyenBay> lstChuyenBayKhoiHanhTruoc12hTaiMoiGa();

    //Cau 28
    @Query(value = "select distinct cb.* from chuyenbay cb,maybay mb\n" +
            "where DoDai < TamBay and Loai  Like 'Boeing%'",nativeQuery = true)
    public List<ChuyenBay> getDSChuyenBayBayBangBoeing();
}
