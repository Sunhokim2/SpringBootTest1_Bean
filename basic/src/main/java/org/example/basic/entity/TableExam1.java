package org.example.basic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "table_exam_1")
@Data
public class TableExam1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY 전략을 사용하여 자동 증가하는 기본 키를 생성합니다.
    Integer id;

    Integer content;
    String brand;
}
