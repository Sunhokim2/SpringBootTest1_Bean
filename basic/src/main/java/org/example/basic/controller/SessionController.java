package org.example.basic.controller;

import java.util.Date;

import org.example.basic.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SessionController {
    // 세션 관련 메서드들
    // 예: 세션 생성, 조회, 삭제 등

    // 같은 origin에서는 쿠키에 저장된 값이 그대로 유지된다.
    // 세션은 서버사이드, 쿠키는 클라이언트 사이드
    // 세션에서 사용되는 쿠키는 "자바스크립트공격"방지를 위해 js로 제어할수 없다. ✨즉, Spring에서 HttpOnly 설정을 해줘서 이게
    // 가능하다.✨
    @GetMapping("ses/login")
    public String Slogin() {
        return "sLogin";
    }

    @PostMapping("ses/login")
    public String postSlogin(
            User user,
            HttpSession session) {
        // 로그인 시간 저장
        Date loginTime = new Date();

        session.setAttribute("user", user);
        session.setAttribute("loginTime", loginTime); // 로그인 시간 세션에 저장

        return "redirect:/correct";
    }

    @PostMapping("ses/logout")
    public String postSlogout(HttpSession session) {
        // session.removeAttribute("user"); // 세션에서 user 제거
        session.invalidate(); // 세션 무효화 : 이거 추천

        return "redirect:/ses/login"; // 로그인 페이지로 리다이렉트
    }

    @GetMapping("correct")
    public String getCorrect() {
        return "correct";
    }

}
