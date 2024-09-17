package org.hj.timebean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class writeController {

    //게시물 작성 폼 호출
    @GetMapping("/newWrite")
    public String newWrite(){
        return "/main/write";
    }
    //글, 사진, 영상, gif 등록 가능
    //폼 받아서 저장


    //수정과 삭제는 마이페이지에서만 가능하다
    //수정하기 기능
    //삭제하기 기능
}
