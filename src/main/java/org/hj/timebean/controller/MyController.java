package org.hj.timebean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyController {

    @GetMapping("/my") //my/{accountId}"
    public String myPage(/*@PathVariable("accountId") String accountId*/) {
        return "main/my";
    }

    //내가 쓴 글 목록 보기
    //좋아요한 글 목록보기

}
