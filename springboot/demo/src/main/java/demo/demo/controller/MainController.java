package demo.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MainController {
    @GetMapping("/board")
    public String board(
            @RequestParam String param,
            @RequestParam String name) {
        return name + ")) 게시물 번호 : " + param;
    }

    @GetMapping("json1")
    @ResponseBody
    public ResponseEntity<String> json1() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("123");
    }

}
