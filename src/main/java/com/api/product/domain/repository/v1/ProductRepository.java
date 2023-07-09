package com.api.product.domain.repository.v1;

import com.api.product.domain.model.v1.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {


    @Query(value = "SELECT * FROM tb_product WHERE nameProduct = ?1",nativeQuery = true)
    Optional<ProductModel> findByNameProduct(String nameProduct);


    @Query(value = "SELECT * From tb_product",nativeQuery = true)
    List<ProductModel> getAll();
}
