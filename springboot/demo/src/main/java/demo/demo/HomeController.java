package demo.demo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
    @Autowired String Bean1; // @Autowired : Bean1을 주입받음
    @Autowired JdbcTemplate jdbcTemplate; // @Autowired : JdbcTemplate을 주입받음
    @Autowired ImageUtil imageUtil; // @Autowired : ImageUtil을 주입받음

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
        return "home";  // templets/home.html 파일 동작함
    }
    
    @GetMapping("/home2")
    @ResponseBody 
    public List<Map<String, Object>> home2() {
        String sql ="Select * from User"; // SQL 쿼리문
        List<Map<String, Object>> list = 
             jdbcTemplate.queryForList(sql);
        
        return list;  
    }
}
