package org.example.basic.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    /**
     * // 상대방 Player에서 사용하는 변수명으로 매핑합니다.
     * // fetch = FetchType.EAGER는 연관된 엔티티를 즉시 로딩합니다.
     * // 기본값은 LAZY입니다. ❗❗❗✨✨✨ 1방향에서 N 방향으로 접근 시는 Lazy관련 에러가 생긴다.
     * // 이걸쓰기보단 TRansactional을 붙여서 해결하자. 왜냐면 N+1상황이 발생해서 쿼리문을 계속 날리기 때문이다.(아마도)
     * 
     * 암튼 이런 문제들때문에 onetoMany는 꼭필요한거 아니면 지양하는게 좋다.
     */
    @OneToMany(mappedBy = "team")
    // , fetch = FetchType.EAGER)
    List<Player> players;
}