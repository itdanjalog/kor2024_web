package day65task.model.entity;

import day65task.model.dto.CategoryDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno; // 카테고리번호

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String cname; // 카테고리명


    // 하나의 카테고리는 여러 상품을 가질 수 있음
    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL) // mappedBy 엔티티이름 정확하게 작성해야함 주의
    @Builder.Default
    List<ProductEntity> productEntityList = new ArrayList<>();

    // entity --> dto로 변환
    public CategoryDto toCategoryDto() {
        return CategoryDto.builder()
                .cno(this.cno)
                .cname(this.cname)
                .build();
    }
}
