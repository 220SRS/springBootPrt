package com.example.firstproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //RestAPI용 컨트롤러! JSON을 반영
public class FirstApiController {
    //일반 컨트롤러는 뷰페이지를 return하지만 rest 컨트롤러는 JSON 및 일반 문자열을 반환한다
    @GetMapping("/api/hello")
    public String hello() {
        return "hello World!";
    }
}
