package org.example.basic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "assembly_member")
@Data
public class AssemblyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY 전략을 사용하여 자동 증가하는 기본 키를 생성합니다.
    Integer id;

    @Column(length = 10, name = "schUnitCd")
    String schUnitcd; // sch_unitcd

    @Column(name = "row_num")
    Integer rowNum; // row_num

    @Column(length = 20, name = "empNo")
    String empNo;

    @Column(length = 20)
    String monaCd;

    @Column(length = 20)
    String hgNm;

    @Column(length = 20)
    String hjNm;

    @Column(length = 20)
    String engNm;

    Integer age;

    @Column(length = 20)
    String sexGbnNm;

    @Column(length = 200)
    String deptImgUrl;

    @Column(length = 20)
    String polyCd;

    @Column(length = 20)
    String polyNm;

    @Column(length = 20)
    String origNm;

    @Column(length = 20)
    String eleGbnNm;

    @Column(length = 20)
    String reeleGbnNm;

    @Column(length = 20)
    String unitCd;

    @Column(length = 200)
    String units;

    @Column(length = 20)
    String cmitNm;

    @Column(length = 500)
    String cmits;

    @Column(length = 20)
    String telNo;

    @Column(length = 20)
    String eMail;

    @Column(length = 200)
    String homepage;

    @Column(length = 20)
    String staff;

    @Column(length = 20)
    String secretary;

    @Column(length = 20)
    String secretary2;

    @Column(length = 20)
    String bthDate;

    @Column(length = 20)
    String unitNm;

    @Column(length = 200)
    String linkUrl;

    @Column(length = 20)
    String openNaId;

}
