package day63.service;

import day63.model.entity.MemberEntity;
import day63.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired private MemberRepository memberRepository;

    // 1. 회원가입
    public boolean signup(MemberEntity memberEntity ){
        memberRepository.save( memberEntity );
        return true;
    }
    // 2. 모든 회원목록 조회
    public List<MemberEntity> infolist( ){
        return memberRepository.findAll();
    }
} // class end











