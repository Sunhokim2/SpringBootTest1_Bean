package org.example.basic.respository;

import org.example.basic.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository
        extends JpaRepository<Team, Integer> {
}