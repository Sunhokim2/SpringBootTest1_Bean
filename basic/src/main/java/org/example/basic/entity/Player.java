package org.example.basic.entity;

import org.example.basic.dto.PlayerDTO;
import org.example.basic.dto.TeamDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity(name = "player")
@ToString(exclude = "team")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int playerId;
    String playerName;

    // @JsonIgnore // JSON으로 변환할 때 무한 참조를 방지하기 위해 사용합니다.
    // @JsonIgnore를 사용하면 JSON으로 변환할 때 이 필드를 무시합니다.
    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;

    public PlayerDTO toDTO() {
        return null;
    }

    public PlayerDTO toDto() {
        TeamDTO teamDto = (team != null) ? new TeamDTO(team.getTeamId(), team.getTeamName(), null) : null;
        return new PlayerDTO(playerId, playerName, teamDto);

    }

    public PlayerDTO toDtowithoutTeam() {
        return new PlayerDTO(playerId, playerName, null);
    }
}
