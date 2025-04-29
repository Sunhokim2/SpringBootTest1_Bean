package org.example.basic.respository;

import org.example.basic.entity.HolidayParking;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HolidayParkingRepository extends JpaRepository<HolidayParking, Long> {
    Page<HolidayParking> findByInstitutionContainingOrSidoContainingOrGuContaining(
            String institution, String sido, String gu, Pageable pageable);

}
