package day65task.model.dto;

import day65task.model.entity.OrderEntity;
import lombok.*;

@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class OrderDto {
    private int ono;
    private boolean ostate;
    private String ocdate;// 주문시간

    // dto --> entity
    public OrderEntity toOrderEntity() {
        return OrderEntity.builder()
                .ono(this.ono)
                .ostate(this.ostate)
                .build();
    }

}
