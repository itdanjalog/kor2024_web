package day65task.controller;

import day65task.model.dto.CategoryDto;
import day65task.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // 5. 카테고리 등록 POST
    @PostMapping("/category/regist")
    public boolean categoryRegist(@RequestBody CategoryDto categoryDto) {
        return categoryService.categoryRegist(categoryDto);
    }

    // 6. 카테고리 조회 G
    @GetMapping("/category/findAll")
    public List<CategoryDto> findCategoryList(){
        return categoryService.findCategoryList();
    }
}
