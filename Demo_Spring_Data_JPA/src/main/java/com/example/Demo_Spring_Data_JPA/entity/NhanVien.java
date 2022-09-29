package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "nhanvien")
@ToString
public class NhanVien implements Serializable {
    @Id
    @Column(name = "MaNV")
    private String MaNV;

    @Column(name = "Ten")
    private String Ten;

    @Column(name = "Luong")
    private Integer Luong;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanvien")
//    private Collection<ChungNhan> lstChungNhan;

}
