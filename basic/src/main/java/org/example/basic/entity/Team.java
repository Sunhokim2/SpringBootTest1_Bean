package org.example.basic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "team")
public class Team {
    @Id // 기본 키를 나타내는 어노테이션입니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY 전략을 사용하여 자동 증가하는 기본 키를 생성합니다.
    Integer teamId;

    String teamName;
}