package day65task.service;

import day65task.model.dto.OrderDto;
import day65task.model.entity.MemberEntity;
import day65task.model.entity.OrderEntity;
import day65task.model.entity.ProductEntity;
import day65task.repository.MemberRepository;
import day65task.repository.OrderRepository;
import day65task.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProductRepository productRepository;

    // 9. 특정 회원이 제품을 주문
    @Transactional
    public boolean myProductOrder(@RequestBody OrderDto orderDto){
        // 로그인 된 회원이 주문한다는 가정하기위해 로그인 mno 샘플값 넣어둠
        int loginMno = 1;

        // 1. 현재 회원번호의 회원엔티티 조회
        Optional<MemberEntity> optionalMember = memberRepository.findById(loginMno);

        // 조회된 엔티티가 없으면
        if(optionalMember.isPresent() == false) {
            return false; //false 로 반환
        }// if end

        MemberEntity memberEntity = optionalMember.get(); //

        // 2. 주문 엔티티 생성
        OrderEntity orderEntity = orderDto.toOrderEntity();

        // 3. 주문 엔티티에 회원번호 넣어주기
        orderEntity.setMemberEntity(memberEntity);

        // 4. 주문 엔티티 꺼내기
        OrderEntity saveEntity = orderRepository.save(orderEntity);

        // 5. 엔티티 저장을 성공하면 PK번호(ono)를 확인하여 0보다 크면 성공
        if(saveEntity.getOno() > 0 ) {
            return true;
        } else {
            return false;
        }// if else end
    }// myProductOrder

    // 10. 특정 회원이 주문한 제품 내역 조회 G
    public List<OrderDto> myOrderList(@RequestParam int mno){
        // 1. 특정회원(mno) 회원 엔티티를 찾는다.
        Optional< MemberEntity> optionalMember = memberRepository.findById(mno);
        if(optionalMember.isPresent()){
            // findbyid로 찾은 회원번호의 엔티티가 존재하면
            MemberEntity memberEntity = optionalMember.get(); // optional 객체에서 엔티티를 꺼냄

            // 2. 찾은 엔티티에서 양방향으로 설정된 주문리스트 조회
            List< OrderEntity> orderEntityList = memberEntity.getOrderEntityList();

            // 3. 모든 주문 엔티티를 dtofh 변환
            List<OrderDto> orderList = orderEntityList.stream()
                    .map(OrderEntity :: toOrderDto)
                    .collect(Collectors.toList());

            // orderList 반환
            return orderList;
        }// if end
        return null;
    }// myOrderList end

    // 11. 특정 회원의 주문이 완료되면 주문상태 변경(주문내역 수정) PUT
    @Transactional
    public boolean myOrderUpdate(@RequestBody OrderDto orderDto){
        // 어떤(로그인 된)회원의 주문번호를 가져오는 샘플값 넣어둠
        int orderNo = 3;

        // 1. 특정 주문번호의(orderNo) 엔티티를 찾는다.
        Optional<OrderEntity> optionalOrder = orderRepository.findById(orderNo);
        // 조회된 엔티티가 없으면
        if(optionalOrder.isPresent() == false) {
            return false; //false 로 반환
        }// if end

        OrderEntity orderEntity = optionalOrder.get();

        // 2.상품 찾기 없으면 false 반환
        ProductEntity productEntity = orderEntity.getProductEntity();
        if(productEntity == null ) {
            return false;
        }// if end

        // 3. 재고 확인 1개 미만이먄 false 반환
        if(productEntity.getPstock() < 1) {
            return false;
        }// if end

        // 4. 재고가 있으면 감소시키고 (재고 수량 필드를 안넣어놔서 한 번 주문시 재고 하나 차감으로 설정함)
        productEntity.setPstock(productEntity.getPstock() -1);
        productRepository.save(productEntity);

        // 5. 주문상태도 변경
        orderEntity.setOstate(true);
        orderRepository.save(orderEntity);

        return true;
    }// myOrderUpdate end
}
