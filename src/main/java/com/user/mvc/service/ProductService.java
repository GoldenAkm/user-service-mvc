package com.user.mvc.service;

import com.user.mvc.dto.ProductDto;
import com.user.mvc.entity.Product;
import com.user.mvc.mapper.ProductMapper;
import com.user.mvc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> getAll() {
        return productRepository.findAll().stream()
                .map(productMapper::getProductDto)
                .collect(Collectors.toList());
    }

    public void getByName(String name, Model model) {
        Product product = productRepository.findByName(name);
        model.addAttribute("product", product);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

}
