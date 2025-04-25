package org.example.basic.dto;

import org.example.basic.entity.Team;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // JSON 직렬화 시 null인 필드는 포함하지 않도록 설정합니다.
public class PlayerDTO {
    int playerId;
    String playerName;

    TeamDTO team;

}
