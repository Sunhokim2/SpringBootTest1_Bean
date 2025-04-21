package demo.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MainController {
    @GetMapping("/board")
    public String board(
        @RequestParam String param, 
        @RequestParam String name) {
            return name + ")) 게시물 번호 : " + param;
    }
    
}
