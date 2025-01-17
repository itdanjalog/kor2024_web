package day65.service;

import day65.model.entity.BoardEntity;
import day65.model.entity.MemberEntity;
import day65.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired private MemberRepository memberRepository;

    // [1] 내가 쓴글 전체 조회
    public List<BoardEntity> myBoardList( int mno ){
        // 1. mno 의 회원 엔티티를 찾는다.
            // Optional 클래스 : null 값을 포함 할수 있는 객체
            // 특징 : Null 값을  안전하게 유무 판단
            // 주요메소드 :
                // 1. isPresent() : 값 존재 여부 판단 함수
                // 2. get() : Optional 객체가 갖고 있는 값 반환 함수
            // 사용처 : JPA의 findById() 함수의 반환 타입
        Optional<MemberEntity> optionalMember = memberRepository.findById( mno );
        if( optionalMember.isPresent() ) { // 만약에 findById함수로 찾은 mno의 엔티티가 존재하면
            MemberEntity entity = optionalMember.get(); // Optional 객체에서 엔티티를 꺼낸다.
            // 2. 찾은 엔티티에서 양방향으로 설정된 게시물 조회
            List<BoardEntity> boardEntityList = entity.getBoardEntityList();
            return boardEntityList;
        }
        return null;
    } // f end
} // c end
