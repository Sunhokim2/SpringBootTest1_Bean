package org.example.basic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "table_exam_1")
public class TableExam1 {

    @Id
    Integer id;

    Integer content;
    String brand;
}
