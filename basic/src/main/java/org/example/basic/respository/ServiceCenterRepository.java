package org.example.basic.respository;

import org.example.basic.entity.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCenterRepository
        extends JpaRepository<ServiceCenter, Integer> {
}