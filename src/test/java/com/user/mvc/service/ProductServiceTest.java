package com.user.mvc.service;

import com.user.mvc.dto.ProductDto;
import com.user.mvc.entity.Product;
import com.user.mvc.mapper.ProductMapper;
import com.user.mvc.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private static final String NAME = "Mouse";

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @Test
    void getAll_IfSuccess_ShouldGetAllProducts() {
        Product product = getProductObject();
        ProductDto productDtoObject = getProductDtoObject();

        Mockito.when(productRepository.findAll()).thenReturn(List.of(product));
        Mockito.when(productMapper.getProductDto(product)).thenReturn(productDtoObject);

        List<ProductDto> actual = productService.getAll();
        assertEquals(List.of(productDtoObject), actual);
    }

    @Test
    void getByName_IfSuccess_ShouldGetByName() {
        Product product = getProductObject();
        Model model = new ExtendedModelMap();

        Mockito.when(productRepository.findByName(NAME)).thenReturn(product);

        productService.getByName(NAME, model);
        Mockito.verify(productRepository, Mockito.times(1)).findByName(NAME);
    }

    @Test
    void addProduct_ifSuccessShouldAddProduct() {
        Product product = getProductObject();

        productService.addProduct(product);
        Mockito.verify(productRepository, Mockito.times(1)).save(product);
    }

    private static Product getProductObject() {
        var product = new Product();
        product.setName("Mouse");
        product.setPrice(25);
        product.setExpDate(LocalDateTime.of(2023, 8, 1, 19, 35, 23));
        product.setId(2);
        return product;
    }

    public static ProductDto getProductDtoObject() {
        var productDto = new ProductDto();
        productDto.setName("Mouse");
        productDto.setPrice(25);
        productDto.setExpDate(LocalDateTime.of(2023, 8, 1, 19, 35, 23));
        return productDto;
    }
}