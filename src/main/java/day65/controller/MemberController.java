package day65.controller;

import day65.model.entity.BoardEntity;
import day65.model.repository.MemberRepository;
import day65.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired private MemberService memberService;

    //  [1] 내가 쓴글 전체 조회
    @GetMapping("/info/board/findall")
    public List<BoardEntity> myBoardList(@RequestParam int mno ){
        return memberService.myBoardList( mno );
    }

}
