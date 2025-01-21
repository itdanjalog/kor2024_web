package day65task.service;

import day65task.model.dto.ProductDto;
import day65task.model.entity.CategoryEntity;
import day65task.model.entity.ProductEntity;
import day65task.repository.CategoryRepository;
import day65task.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // 7. 상품 등록 POST
    @Transactional
    public boolean registProduct(@RequestBody ProductDto productDto){

        // 상품은 어느 한 카테고리에 참조 되어있어야하기떄문에 샘플 값을 넣어둠
        int categoryNo = 1;

        // 1. 카테Rh리 엔티티 찾기
        Optional< CategoryEntity> optionalCategoryEntity = categoryRepository.findById(categoryNo);

        // 조회된 엔티티가 없으면
        if(optionalCategoryEntity.isPresent() == false ) {
            return false; // false로 반환
        } //if end

        // 찾은 카테고리 엔티티 설정
        CategoryEntity categoryEntity = optionalCategoryEntity.get();

        // 2. 상품 엔티티 생성
        ProductEntity productEntity = productDto.toProductEntity();

        // 3. 상품 엔티티에 카테고리 넣어주기
        productEntity.setCategoryEntity(categoryEntity);

        // 4. 상품 엔티티 꺼내기
        ProductEntity saveEntity = productRepository.save(productEntity);

        // 5. 엔티티 저장을 성공하면 Pk번호(pno)를 확인해서 0보다 크면 성공
        if(saveEntity.getPno() > 0){
            return true;
        } else {
            return false;
        } // if-else end

    }// registProduct end


    // 8. 특정 카테고리에 포함되어있는 상품 조회 GET
    public List<ProductDto> findProductId(@RequestParam int cno) {
        // 1. 특정 카테고리(Cno) 회원 엔티티를 찾는다.
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(cno);
        if(optionalCategory.isPresent()) {
            CategoryEntity categoryEntity = optionalCategory.get();
            List<ProductEntity> productEntityList = categoryEntity.getProductEntityList();
            List<ProductDto> productList = productEntityList.stream()
                    .map(ProductEntity :: toProductDto)
                    .collect(Collectors.toList());

            return productList;
        }// if end
        return null;
    }// findProductId end

}
