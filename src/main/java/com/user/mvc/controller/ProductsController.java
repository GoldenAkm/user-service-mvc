package com.user.mvc.controller;

import com.user.mvc.dto.ProductDto;
import com.user.mvc.entity.Product;
import com.user.mvc.entity.User;
import com.user.mvc.mapper.ProductMapper;
import com.user.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {  // TODO: Session

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public String getProductsPage() {
        return "products/products";
    }

    @GetMapping("/all")
    public List<ProductDto> getPruductList(){
        return productService.getAll();
    }

    @PostMapping ("/addProduct")
    public String addProduct(@ModelAttribute @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") ProductDto productDto) {
        Product product = productMapper.getProductEntity(productDto);
        productService.addProduct(product);
        return "/products/product-add";
    }
    @GetMapping("/this-product")
    public String getProductDetails(@RequestParam String name, Model model) {
        productService.getByName(name, model);
        return "products/product-details";
    }

}
