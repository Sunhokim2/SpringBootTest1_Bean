package org.example.basic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.basic.respository.PostTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QueryController {
    @Autowired
    PostTagRepository postTagRepository;

    @GetMapping("/post-tag")
    @ResponseBody
    public List<Map<String, Object>> getMethodName() {

        return postTagRepository.findAll2().stream()
                .map(row -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("tag_name", (String) row[0]);
                    map.put("count", (int) row[1]);
                    return map;
                })
                .toList();

    }

}
