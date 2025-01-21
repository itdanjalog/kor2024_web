package day65task.model.entity;

import day65task.model.dto.OrderDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "orders")
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
@DynamicInsert // @ColumnDefalut 어노테이션 사용하기 위해 쓰는 어노테이션
public class OrderEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ono;

    @Column(columnDefinition = "boolean")
    @ColumnDefault("0")
    private boolean ostate;

    @ManyToOne // fk
    @JoinColumn(name = "mno") // 회원테이블 mno를 참조함
    private MemberEntity memberEntity;

    @ManyToOne
    @JoinColumn(name = "pno") // 상품테이블에 pno를 참조함
    private ProductEntity productEntity;

    // entity --> dto 로 변환
    public OrderDto toOrderDto() {
        return OrderDto.builder()
                .ono(this.ono)
                .ostate(this.ostate)
                .ocdate(this.getCdate().toString())
                .build();
    }
}
