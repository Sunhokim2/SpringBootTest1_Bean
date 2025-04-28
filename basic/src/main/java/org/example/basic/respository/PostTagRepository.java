package org.example.basic.respository;

import java.util.List;

import org.example.basic.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTagRepository
        extends JpaRepository<Post, Long> {
    @Query(value = """
            select tag_name, COUNT(*) AS count
            from post_tag
            Group BY tag_name
            ORDER BY count DESC
            LIMIT 10
            """, nativeQuery = true)
    List<Object[]> findAll2();
}