package org.example.basic.dto;

import java.util.List;

import org.example.basic.entity.Player;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
/**
 * 아래꺼 2개는 기본생성자,
 * 모든 멤버변수를 입력받는 생성자
 * 그래서 new TeamDTO(1, "팀A", null) 이런식으로 사용가능하다.
 */
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // JSON 직렬화 시 null인 필드는 포함하지 않도록 설정합니다.
public class TeamDTO {

    Integer teamId;

    String teamName;

    List<PlayerDTO> players;
}
