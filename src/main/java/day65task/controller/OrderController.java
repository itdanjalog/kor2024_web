package day65task.controller;

import day65task.model.dto.OrderDto;
import day65task.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 9. 특정 회원이 제품을 주문 POST
    @PostMapping("/member/product/order")
    public boolean myProductOrder(@RequestBody OrderDto orderDto){
        return orderService.myProductOrder(orderDto);
    }

    // 10. 특정 회원이 주문한 제품 내역 조회 G
    @GetMapping("/member/product/find")
    public List<OrderDto> myOrderList(@RequestParam int mno){
        return orderService.myOrderList(mno);
    }

    // 11. 특정 회원의 주문이 완료되면 주문상태 변경(주문내역 수정) PUT
    @PutMapping("/member/order/udpate")
    public boolean myOrderUpdate(@RequestBody OrderDto orderDto){
        return orderService.myOrderUpdate(orderDto);
    }
}
