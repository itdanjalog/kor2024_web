package day65task.controller;

import day65task.model.dto.ProductDto;
import day65task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    // 7. 상품 등록 POST
    @PostMapping("/proudct/regist")
    public boolean registProduct(@RequestBody ProductDto productDto){
        return productService.registProduct(productDto);
    }


    // 8. 특정 카테고리에 포함되어있는 상품 조회 GET
    @GetMapping("/info/product/find")
    public List<ProductDto> findProductId(@RequestParam int cno) {
        return productService.findProductId(cno);
    }

}
