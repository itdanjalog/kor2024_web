package day65task.controller;

import day65task.model.dto.MemberDto;
import day65task.model.dto.OrderDto;
import day65task.model.dto.ProductDto;
import day65task.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;


    // 1. 회원가입 POST
    @PostMapping("/member/signup")
    public boolean signup(@RequestBody MemberDto memberDto){
        return memberService.signup(memberDto);
    }

    // 2. 로그인 POST
    @PostMapping("/member/login")
    public boolean login(@RequestBody MemberDto loginMemberDto){
        return memberService.login(loginMemberDto);
    }

    // 3. 전체 회원 목록 조회하기 G
    @GetMapping("/member/findAllMember")
    public List<MemberDto> findAllMember() {
        return memberService.findAllMember();
    }

    // 4. 특정 회원 정보 조회하기 G
    public MemberDto findMemberInfo(@RequestParam int mno) {
        return memberService.findMemberInfo(mno);
    }






}
