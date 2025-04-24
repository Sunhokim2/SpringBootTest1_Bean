package org.example.basic.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Major {
    @Id
    Integer Id;

    @Column(length = 50)
    String name;

    Integer maxPrsn;

    @Temporal(TemporalType.DATE)
    Date ebtbDate;
}
