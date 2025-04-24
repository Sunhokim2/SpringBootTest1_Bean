package org.example.basic.respository;

import org.example.basic.entity.TableExam1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableExam1Repository extends JpaRepository<TableExam1, Integer> {
    // JpaRepository<TableExam1, Integer>는 TableExam1 엔티티를 Integer 타입의 ID로 관리하는 JPA
    // 리포지토리 인터페이스입니다.
    // 기본 CRUD 메서드와 페이징, 정렬 기능을 제공합니다.

}
