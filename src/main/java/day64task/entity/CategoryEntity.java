package day64task.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class CategoryEntity extends BaseTime{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int cno; // 카테고리 번호

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String cname; // 카테고리명

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    private List<ProductEntity> productEntityList = new ArrayList<>();

}
