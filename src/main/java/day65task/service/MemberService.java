package day65task.service;

import day65task.model.dto.MemberDto;
import day65task.model.dto.OrderDto;
import day65task.model.entity.MemberEntity;
import day65task.model.entity.OrderEntity;
import day65task.repository.MemberRepository;
import day65task.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private OrderRepository orderRepository;


    // 1. 회원가입
    public boolean signup(@RequestBody MemberDto memberDto){
        //1. DTO를 Entity로 변환한한 toMemberEntity를 가져옴
        MemberEntity memberEntity = memberDto.toMemberEntity();

        // 2. 변환된 엔티티를 Save하고 그 결과 entity를 반환 받는다.
        MemberEntity saveEntity = memberRepository.save(memberEntity);

        // 3. 회원가입 해놓고 mno가 제대로 생성 되었는지 여부 확인해서 return값 반환
        if(saveEntity.getMno() > 0) {
            return true;
        } else{
            return false;
        }// if- else end
    }// signup end

    // 2. 로그인 POST
    public boolean login(@RequestBody MemberDto loginMemberDto){
        // 아이디, 비밀번호 샘플 데이터
        String loginMid = "qwer";
        String lonigMpwd = "1234";

        // 입력값 비교
        if(loginMemberDto.getMid().equals(loginMid) && loginMemberDto.getMpwd().equals(lonigMpwd)) {
            return true;
        } return false; // if end
    }// login end


    // 3. 전체 회원 목록 조회하기 G
    public List<MemberDto> findAllMember() {
        //1. 모든 엔티티를 조회
        List<MemberEntity> entityList = memberRepository.findAll();

        //2. 모든 게시물 엔티티를 dto로 변환
        List<MemberDto> list = entityList.stream()
                .map(MemberEntity :: toMemberDto)
                .collect(Collectors.toList());

        return list;
    } // findAlMember

    // 4. 특정 회원 정보 조회하기 G
    public MemberDto findMemberInfo(@RequestParam int mno) {
        //1. 지정한 Mno의 회원 엔티티를 찾는다.
        Optional<MemberEntity> optionalMember = memberRepository.findById(mno);

        if(optionalMember.isPresent()){
            // 만약에 findNyId 함수로 찾은 Mno의 엔티티가 존재하면 Optional객체에서 엔티팉를 꺼낸다.
            MemberEntity entity  = optionalMember.get();

            //2. 찾은 엔티티를 DTO로 변환
            MemberDto findMemberDto = entity.toMemberDto();

            return findMemberDto;
        }
        return null;
    }


}
