package org.example.basic.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.example.basic.entity.AssemblyMember;
import org.example.basic.entity.ServiceCenter;
import org.example.basic.respository.AssemblyMemberRepository;
import org.example.basic.respository.ServiceCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JpaController {
    @Autowired
    ServiceCenterRepository serviceCenterRepository;
    @Autowired
    AssemblyMemberRepository amr;

    @GetMapping("/sc/add")
    @ResponseBody
    public ServiceCenter scAdd(
            @ModelAttribute ServiceCenter sc) {

        LocalDateTime now = LocalDateTime.now();
        sc.setPurDate(now);

        ServiceCenter result = serviceCenterRepository.save(sc);
        return result;

    }

    @GetMapping("/sc/list")
    @ResponseBody
    public List<ServiceCenter> scList() {
        List<ServiceCenter> list = serviceCenterRepository.findAll();
        return list;
    }

    @GetMapping("/sc/modify")
    @ResponseBody
    public ServiceCenter scModify(
            @ModelAttribute ServiceCenter sc) {
        // 수정으 ㄹ위해 DB의 데이터를 조회
        Optional<ServiceCenter> optional = serviceCenterRepository.findById(sc.getId());

        // 퍼데이트는 이전꺼 그대로 사용
        ServiceCenter savedSc = optional.get();
        sc.setPurDate(savedSc.getPurDate());
        ServiceCenter result = serviceCenterRepository.save(sc);
        return result;
    }

    // 어셈블리멤버 entity 사용
    @GetMapping("/assembly_member")
    @ResponseBody
    public List<AssemblyMember> assemblyMember(
            @RequestParam(defaultValue = "1") Integer page, // 페이지 번호 (기본값 1)
            @RequestParam(defaultValue = "10") Integer count // 페이지당 데이터 개수 (기본값 10)
    ) {
        Order order = Order.desc("id");
        Sort sort = Sort.by(order); // 정렬 기준 설정
        // 페이징 처리 (data.domain.Pageable)
        Pageable pagable = PageRequest.of(page - 1, count, sort); // 페이지 번호 0, 페이지당 10개

        // 페이지(data.domain.Page)로 조회
        Page<AssemblyMember> list = amr.findAll(pagable);
        return list.getContent();
    }

}
