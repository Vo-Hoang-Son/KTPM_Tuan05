package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "maybay")
@ToString
public class MayBay implements Serializable {

    @Id
    @Column(name = "MaMB")
    private Integer MaMB;

    @Column(name = "Loai")
    private String Loai;

    @Column(name = "TamBay")
    private Integer TamBay;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maybay")
//    private Set<ChungNhan> lstChungNhan = new HashSet<>();
}
