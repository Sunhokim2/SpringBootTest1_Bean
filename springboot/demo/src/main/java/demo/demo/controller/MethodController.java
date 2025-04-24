package demo.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import demo.demo.model.Computer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class MethodController {
    // 세션과 파라미터 요청
    @GetMapping("req/get")
    public String get(
            HttpSession session,

            // Integer는 기본값이 null이므로 @RequestParam(required = false)로 생략 가능
            // int는 기본값이 0이므로 @RequestParam(required = false) 사용 불가
            @RequestParam(defaultValue = "1", required = false) Integer page,
            @RequestParam(required = false) String search) {
        session.setAttribute("page", page);
        return String.format("get method called with\n param: %s, param2: %s",
                page, search);
    }

    @PostMapping("req/post")
    public String post(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

    // 쿠기 테스트
    @GetMapping("req/http")
    // ❗❗ 이건 모든 것을 받는 큰 통이라생각하면됨
    public String getMethodName(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String id = cookie.getValue();
            System.out.println(id);
        }

        String name = request.getParameter("name");
        String value = request.getParameter("value");

        return name + " : " + value;
    }

    // model 이용하기
    @GetMapping("req/model")
    public String model(
            // 생략하면 자동으로 @ModelAttribute가 붙는다.
            @ModelAttribute Computer computer) {
        // @ModelAttribute는 @RequestParam과 @RequestBody를 모두 포함하는 어노테이션이다.

        return computer.toString() + "\n" +
                "cpu: " + computer.getCpu() + "\r\n" +
                "ram: " + computer.getRam() + "\n" +
                "power: " + computer.getPower() + "\n" +
                "ssd: " + computer.getSsd() + "\n";
    }
}
