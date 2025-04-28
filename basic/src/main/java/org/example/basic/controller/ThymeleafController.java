package org.example.basic.controller;

import java.util.HashMap;
import java.util.Map;

import org.example.basic.entity.HolidayParking;
import org.example.basic.respository.HolidayParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {
    @GetMapping("/user-1")
    public String user(Model model) {
        Map<String, Object> user = new HashMap<>();
        user.put("userId", "z");
        user.put("userName", "zoo");
        user.put("userAge", 25);
        model.addAttribute("user", user);
        return "user";
    }

    // 페이지 넘어가는 숫자 양식
    @GetMapping("pagination")
    public String pagination(
            Model model,
            @RequestParam(defaultValue = "1") int page) {
        int startPage = (page - 1) / 10 * 10 + 1;
        int endPage = startPage + 9;
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("page", page);
        return "pagination";
    }

    @Autowired
    HolidayParkingRepository holidayParkingRepository;

    @GetMapping("/holiday-parking")
    public String holidayParking(
            Model model,
            @RequestParam(defaultValue = "1") int page) {
        int startPage = (page - 1) / 10 * 10 + 1;
        int endPage = startPage + 9;
        Pageable pageable = PageRequest.of(page - 1, 10);
        Page<HolidayParking> holidayParkingList = holidayParkingRepository.findAll(pageable);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("page", page);
        model.addAttribute("holidayParkingList", holidayParkingList.getContent());
        model.addAttribute("totalPages", holidayParkingList.getTotalPages());

        return "holiday-parking";
    }
}
