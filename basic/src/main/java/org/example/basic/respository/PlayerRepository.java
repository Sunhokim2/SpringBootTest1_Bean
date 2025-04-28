package org.example.basic.respository;

import java.util.List;

import org.example.basic.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository
                extends JpaRepository<Player, Integer> {

        @Query("""
                        SELECT p
                        FROM player p
                        JOIN FETCH p.team
                                """)
        List<Player> findAll2();
}
