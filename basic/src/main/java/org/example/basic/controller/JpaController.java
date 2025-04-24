package org.example.basic.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.example.basic.entity.ServiceCenter;
import org.example.basic.respository.ServiceCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JpaController {
    @Autowired
    ServiceCenterRepository serviceCenterRepository;

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
        Optional<ServiceCenter> optional = serviceCenterRepository.findById(sc.getId());

        // 퍼데이트는 이전꺼 그대로 사용
        ServiceCenter savedSc = optional.get();
        sc.setPurDate(savedSc.getPurDate());
        ServiceCenter result = serviceCenterRepository.save(sc);
        return result;
    }
}
