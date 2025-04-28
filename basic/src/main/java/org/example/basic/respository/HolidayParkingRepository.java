package org.example.basic.respository;

import org.example.basic.entity.HolidayParking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayParkingRepository extends JpaRepository<HolidayParking, Long> {

}
