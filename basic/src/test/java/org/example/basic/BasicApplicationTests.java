package org.example.basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.StackWalker.Option;
import java.time.LocalDateTime;
import java.util.Optional;

import org.checkerframework.checker.units.qual.t;
import org.example.basic.entity.AssemblyMember;
import org.example.basic.entity.ServiceCenter;
import org.example.basic.respository.AssemblyMemberRepository;
import org.example.basic.respository.ServiceCenterRepository;
import org.example.basic.respository.TableExam1Repository;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class BasicApplicationTests {
    @Autowired
    AssemblyMemberRepository amr;
    @Autowired
    ServiceCenterRepository serviceCenterRepository;
    @Autowired
    TableExam1Repository tableExam1Repository;

    @Test
    public void 국회데이터조회() {
        Optional<AssemblyMember> opt = amr.findById(1);
        AssemblyMember member = null;

        if (opt.isPresent()) {
            member = opt.get();
        } else {
            member = new AssemblyMember();
        }

        System.out.println(member);
    }

    // id, customer, prdName, purDate가 있다
    @Test
    public void 서비스센터데이터입력() {

        ServiceCenter sc = new ServiceCenter();
        sc.setCustomer("변경이름");
        sc.setPrdName("변경상품");
        sc.setId(1); // 변경할 제품의 Id

        // Optional<ServiceCenter> optional =
        // serviceCenterRepository.findById(sc.getId());

        // 퍼데이트는 이전꺼 그대로 사용
        // ServiceCenter savedSc = optional.get();
        // sc.setPurDate(savedSc.getPurDate());

        // 아니면 새롭게 날짜 갱신
        sc.setPurDate(LocalDateTime.now());

        // 서비스센터 데이터 저장
        serviceCenterRepository.save(sc);

        return;
    }

}
