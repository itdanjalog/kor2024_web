package day65task.service;

import day65task.model.dto.CategoryDto;
import day65task.model.entity.CategoryEntity;
import day65task.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // 5. 카테고리 등록 POST
    @Transactional
    public boolean categoryRegist(@RequestBody CategoryDto categoryDto) {
        CategoryEntity categoryEntity = categoryDto.toCategoryEntity();
        CategoryEntity saveEntity = categoryRepository.save(categoryEntity);

        if(saveEntity.getCno() > 0) {
            return true;
        } else {
            return false;
        } //  if-else end
    }// categoryRegist end

    // 6. 카테고리 조회 G
    public List<CategoryDto> findCategoryList(){
        List<CategoryEntity> entityList = categoryRepository.findAll();

        List<CategoryDto> list = entityList.stream()
                .map(CategoryEntity :: toCategoryDto)
                .collect(Collectors.toList());

        return list;
    } // findCategoryList end


}
