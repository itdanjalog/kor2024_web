package day59.service;

import day59.model.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // 스프링 컨테이너(메모리) 에 빈(인스턴스) 주입
public class MemberService {
    // 스프링 컨테이너(메모리)에 존재하는 빈(인스턴스) 호출
    @Autowired private MemberDao memberDao;
}
