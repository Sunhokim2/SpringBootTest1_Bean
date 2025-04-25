package org.example.basic.respository;

import org.example.basic.entity.AssemblyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AssemblyMemberRepository
                extends JpaRepository<AssemblyMember, Integer> {

        // 쿼리 메소드
        List<AssemblyMember> findByHgNm(String hgNm);

        List<AssemblyMember> findByCmits(String cmits);

        List<AssemblyMember> findByHgNmAndCmitsContaining(String hgNm, String cmits);
}
