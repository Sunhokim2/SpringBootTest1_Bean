package demo.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; // ObjectMapper : JSON 변환을 위한 클래스

import demo.demo.ImageUtil;

@Controller
@Slf4j
public class HomeController {
    @Autowired
    String Bean1; // @Autowired : Bean1을 주입받음
    @Autowired
    JdbcTemplate jdbcTemplate; // @Autowired : JdbcTemplate을 주입받음
    @Autowired
    ImageUtil imageUtil; // @Autowired : ImageUtil을 주입받음
    @Autowired
    ObjectMapper objectMapper; // @Autowired : ObjectMapper을 주입받음

    // 컨트롤러 메소드
    @GetMapping("/home")
    public String home() {
        // 빈을 Config에서 주입받음
        // 실행시 이미지를 다운받아 저장한다.
        try {
            imageUtil.downloadImage("http://ggoreb.com/images/luffy.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Bean1);

        log.info("home() called"); // 로그 남기기
        log.error("error!!!"); // 로그 남기기
        return "home"; // templets/home.html 파일 동작함
    }

    @GetMapping("/home2")
    @ResponseBody
    public List<Map<String, Object>> home2() {
        // DB에서 데이터를 가져오는 메소드
        // JdbcTemplate을 사용하여 DB에서 데이터를 가져옴

        String sql = "Select * from User"; // SQL 쿼리문
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

        return list;
    }

    @GetMapping("/home3")
    public String home3(Model model) {
        // 맵을 생성하고
        // 데이터를 추가한 후 model에 추가함
        // home3.html 파일을 동작시킴
        // model : 컨트롤러와 뷰를 연결하는 객체
        // model.addAttribute() : 데이터를 추가하는 메소드

        Map<String, Object> map = new HashMap<>();

        map.put("name", "홍길동"); // map에 데이터 추가
        map.put("age", "20"); // map에 데이터 추가

        String json = "";
        try {
            json = objectMapper.writeValueAsString(map); // map을 JSON으로 변환
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        model.addAttribute("data", json); // model에 data(이름) 추가
        return "home3";
    }
}
