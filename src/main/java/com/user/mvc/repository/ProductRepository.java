package com.user.mvc.repository;

import com.user.mvc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT u FROM products u WHERE u.name = :name")
    Product findByName(@Param("name") String name);

}
