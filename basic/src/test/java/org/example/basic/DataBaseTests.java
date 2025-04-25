package org.example.basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

import java.lang.StackWalker.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.checkerframework.checker.units.qual.t;
import org.example.basic.entity.AssemblyMember;
import org.example.basic.entity.Player;
import org.example.basic.entity.ServiceCenter;
import org.example.basic.entity.Team;
import org.example.basic.respository.AssemblyMemberRepository;
import org.example.basic.respository.PlayerRepository;
import org.example.basic.respository.ServiceCenterRepository;
import org.example.basic.respository.TableExam1Repository;
import org.example.basic.respository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class DataBaseTests {
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;

    /**
     * Test.java에서 fetchType.EAGER를 사용하지않는다면
     * 아니면 여기에 @Transactional을 붙여도 된다
     * 그걸 사용하면 모든 명령어(작업) 끝날때까ㅏ지 DB연결을 유지한다(커넥션 1개만사용)
     * 사용하지 않으면 명령어 한줄 당 DB새로 연결한다.
     * ❗one to many는 그래서 최대한 아껴써야한다.
     * 
     * ✨fetchJoin이란 것도 있다고함
     */
    @Transactional
    @Test
    void contextLoads2() {
        List<Team> list = teamRepository.findAll();
        list.stream().forEach((team) -> { // team그대로 출력하면 양방향참조 에러가 생긴다.
            System.out.println(
                    team.getTeamName() + " " + team.getPlayers().size());
        });
    }

    // 연관관계를 써서 CRUD를 해보자
    @Test
    void contextLoads() {
        List<Player> list = playerRepository.findAll();

        // list.stream().forEach()하나 list.forEach()로 바로하나 동작은 그대로 똑같다
        list.stream().forEach((player) -> {
            System.out.println(player);
        });
    }
}
