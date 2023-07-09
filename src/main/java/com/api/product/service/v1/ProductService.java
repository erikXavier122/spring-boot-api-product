package com.api.product.service.v1;

import com.api.product.domain.model.v1.ProductModel;
import com.api.product.dto.v1.ProductDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    Optional<ProductModel> findById(UUID id);

    List<ProductModel> findAll();


    Object save(ProductModel productModel);


    Object updateById(UUID id, ProductDto productDto);

    Optional<ProductModel> findByNameProduct(String nameProduct);

    Object deleteById(UUID id);

    void delete(ProductModel productModel);

    List<ProductModel> getAll();
}
