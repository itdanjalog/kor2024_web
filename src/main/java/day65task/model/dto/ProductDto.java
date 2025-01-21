package day65task.model.dto;

import day65task.model.entity.ProductEntity;
import lombok.*;

@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class ProductDto {
    private int pno;
    private String pname;
    private int pprice;
    private int pstock;

    public ProductEntity toProductEntity() {
        return ProductEntity.builder()
                .pno(this.pno)
                .pname(this.pname)
                .pprice(this.pprice)
                .pstock(this.pstock)
                .build();
    }
}
