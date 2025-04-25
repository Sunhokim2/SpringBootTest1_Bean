package org.example.basic.respository;

import org.example.basic.entity.AssemblyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssemblyMemberRepository
        extends JpaRepository<AssemblyMember, Integer> {

}
