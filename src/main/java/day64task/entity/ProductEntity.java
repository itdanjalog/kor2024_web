package day64task.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno; // 제품번호

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private  String pname; // 제품명

    @Column(columnDefinition = "int", nullable = false)
    private int pprice; // 제품가격

    @JoinColumn(name = "cno")
    @ManyToOne
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    List<OrderEntity> orderEntityList = new ArrayList<>();
}
