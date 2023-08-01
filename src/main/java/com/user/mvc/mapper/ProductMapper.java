package com.user.mvc.mapper;

import com.user.mvc.dto.ProductDto;
import com.user.mvc.dto.UserDto;
import com.user.mvc.entity.Product;
import com.user.mvc.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDto getProductDto(Product product) {
        var productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setExpDate(product.getExpDate());
        return productDto;
    }
    public Product getProductEntity(ProductDto productDto) {
        var product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setExpDate(productDto.getExpDate());
        return product;
    }

}
