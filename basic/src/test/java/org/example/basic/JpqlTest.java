package org.example.basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import org.example.basic.entity.Comment;
import org.example.basic.entity.Player;
import org.example.basic.entity.Post;

import org.example.basic.respository.CommentRepository;
import org.example.basic.respository.PlayerRepository;
import org.example.basic.respository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class JpqlTest {
    @Autowired
    PlayerRepository playerRepository;

    // repository에서 JPQL을 사용하여
    // Player를 조회하는 테스트입니다.
    @Test
    void test1() {
        List<Player> list = playerRepository.findAll2();
        list.forEach(play -> {
            System.out.printf(
                    "%s %s\n",
                    play.getPlayerId(), play.getPlayerName());
        });

    }
}
