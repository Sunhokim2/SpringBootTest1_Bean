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
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // JSON 직렬화 시 null인 필드는 포함하지 않도록 설정합니다.
public class TeamDTO {

    Integer teamId;

    String teamName;

    List<PlayerDTO> players;
}
