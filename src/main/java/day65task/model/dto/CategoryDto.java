package day65task.model.dto;

import day65task.model.entity.CategoryEntity;
import lombok.*;

@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class CategoryDto {
    private int cno;
    private String cname;

    // dto--> entity로 변환
    public CategoryEntity toCategoryEntity() {
        return CategoryEntity.builder()
                .cno(this.cno)
                .cname(this.cname)
                .build();
    }

}
