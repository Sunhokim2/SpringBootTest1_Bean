package org.example.basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

import java.lang.StackWalker.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.checkerframework.checker.units.qual.A;
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
public class AssemblyMemberTests {
    @Autowired
    AssemblyMemberRepository amr;

    @Test
    void contextLoads() {
        List<AssemblyMember> list = amr.findByHgNm("강기문");
        System.out.println(list);
    }

    @Test
    void testFindByHgNmAndCmitsContaining() {
        List<AssemblyMember> list = amr.findByHgNmAndCmitsContaining("강기문", "재정경제위원회");
        System.out.println(list);

        // 필요한 값만 DTO로 뽑아내기가 가능하다.
        // List<AssemblyMemberDTO> list = amr.findByHgNmAndCmitsContaining("강기문",
        // "재정경제위원회");

    }

}
