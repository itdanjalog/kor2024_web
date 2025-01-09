package day59.controller;

import day59.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController // 스프링 컨테이너(메모리) 에 빈(인스턴스) 주입
public class MemberController {
    // 스프링 컨테이너(메모리)에 존재하는 빈(인스턴스) 호출
    @Autowired private MemberService memberService;
}
