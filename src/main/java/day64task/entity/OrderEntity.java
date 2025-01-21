package day64task.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ono; // 주문번호

    @Column(columnDefinition = "int", nullable = false)
    private int oquantity;

    @ManyToOne
    @JoinColumn(name="pno")
    private ProductEntity productEntity;

}
