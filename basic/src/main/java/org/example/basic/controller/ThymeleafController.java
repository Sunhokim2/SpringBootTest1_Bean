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
            @RequestParam(defaultValue = "1") int page,
            // 파라미터 이름을 searchKeyword로 변경 (HTML과 일치시키기 위해)
            @RequestParam(defaultValue = "") String searchKeyword) {

        int pageSize = 10; // 페이지 당 아이템 수
        Pageable pageable = PageRequest.of(page - 1, pageSize); // page는 1부터 시작, Pageable은 0부터 시작

        // 검색어(searchKeyword)를 사용하여 데이터 조회
        Page<HolidayParking> holidayParkingPage = holidayParkingRepository
                .findByInstitutionContainingOrSidoContainingOrGuContaining(
                        searchKeyword, searchKeyword, searchKeyword, pageable);

        int totalPages = holidayParkingPage.getTotalPages(); // 전체 페이지 수

        // 페이지네이션 블록 계산 (예: 1-10, 11-20)
        int pageBlockSize = 10;
        int startPage = ((page - 1) / pageBlockSize) * pageBlockSize + 1;
        int endPage = startPage + pageBlockSize - 1;
        // endPage가 실제 totalPages보다 크면 totalPages로 조정
        endPage = Math.min(endPage, totalPages);

        // 모델에 데이터 추가
        model.addAttribute("totalPages", totalPages); // 전체 페이지 수
        model.addAttribute("totalElement", holidayParkingPage.getTotalElements()); // 전체 아이템 수
        model.addAttribute("holidayParkingList", holidayParkingPage.getContent());
        model.addAttribute("page", page); // 현재 페이지 번호
        model.addAttribute("searchKeyword", searchKeyword); // 현재 검색어 (입력 필드 유지용)
        model.addAttribute("startPage", startPage); // 페이지네이션 시작 번호
        model.addAttribute("endPage", endPage); // 페이지네이션 끝 번호
        model.addAttribute("totalPages", totalPages); // 전체 페이지 수 (필요시 사용)

        // 만약 검색어인 searchKeyword도 가리고싶으면 모델 addAttribute("searchKeyword",
        // searchKeyword);를 사용한다.

        return "holiday-parking"; // 뷰 이름 반환
    }
}
