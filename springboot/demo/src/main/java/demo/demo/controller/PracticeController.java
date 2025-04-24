package demo.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// get으로 param입력받아서 리턴하기
@RestController
public class PracticeController {

    // if문 처리 방법 ( 파람 입력받아서 일일히 처리 후 map리턴)
    @GetMapping("prac/data")
    public Map<String, Object> reqData(
            @RequestParam String area,
            @RequestParam Integer score) {
        Map<String, Object> map = new HashMap<>();
        if (area != null)
            map.put("area", area);
        if (score != null)
            map.put("score", score);
        return map;
    }

    // 일괄적 맵으로 받기
    @GetMapping("data2") // POST 매핑 사용
    public Map<String, Object> reqData2(@RequestParam Map<String, Object> map) {
        return map;
    }
}
