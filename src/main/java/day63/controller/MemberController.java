package day63.controller;

import day63.model.entity.MemberEntity;
import day63.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    @Autowired private MemberService memberService;
    // 1. 회원가입
    @PostMapping("/member/signup")
    // url : http://localhost:8080/member/signup
    // body : { "mid" : "qwe1" , "mpwd" : "1234" , "mname" : "유재석" , "mphone":"010-3333-3333"}
    public boolean signup(@RequestBody MemberEntity memberEntity ){
        return memberService.signup( memberEntity );
    }  // f end
    // 2. 모든 회원목록 조회
    @GetMapping("/member/infolist")
    // url : http://localhost:8080/member/infolist
    public List< MemberEntity > infoList(){
        return memberService.infolist();
    } // f end

} // class end









