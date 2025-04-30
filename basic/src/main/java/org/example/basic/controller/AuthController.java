package org.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    // 로그인 메인 화면
    @GetMapping("/main")
    public String main() {
        return "/auth/main";
    }

    // 1) 기본 HTML form 로그인 화면
    @GetMapping("/html/login")
    public String htmlLogin() {
        return "/auth/html-login";
    }

    // 1) 기본 form 로그인 POST
    @PostMapping("/html/login")
    public String htmlLoginPost(
            @RequestParam String username,
            @RequestParam String password) {
        // 로그인 성공 가정
        return "redirect:/auth/main";
    }

    // 2) fetch 로그인 화면
    @GetMapping("/fetch/login")
    public String fetchLogin() {
        return "/auth/fetch-login";
    }

    // 2) fetch 로그인 POST
    @PostMapping("/fetch/login")
    @ResponseBody
    public String fetchLoginPost(
            @RequestParam String username,
            @RequestParam String password) {
        // 로그인 성공 가정
        return "success";
    }

    // 3) 크로스 오리진 + form 로그인 POST
    @PostMapping("/cors/html/login")
    public String corsHtmlLoginPost(
            @RequestParam String username,
            @RequestParam String password) {
        return "redirect:/auth/main";
    }

    // 4) 크로스 오리진 + fetch 로그인 POST
    // ❗ 쿠키는 cors해도 전달안된닫. 같은서버인 8080만 된다. 즉, 127.0.0.1:5000로 접속시 안된다.
    // 단, 프론트에서 credentials: "include"로 설정하면 쿠키가 전달된다.
    // 추가로 여기서 allowCredentials ="true"를 해줘야 한다.
    @CrossOrigin(allowCredentials = "true", origins = "http://127.0.0.1:5000")
    @PostMapping("/cors/fetch/login")
    @ResponseBody
    public String corsFetchLoginPost(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) {
        return "success";
    }

}
