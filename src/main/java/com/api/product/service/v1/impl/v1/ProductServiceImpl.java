package com.api.product.service.v1.impl.v1;

import com.api.product.domain.model.v1.ProductModel;
import com.api.product.domain.repository.v1.ProductRepository;
import com.api.product.dto.v1.ProductDto;
import com.api.product.service.v1.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.nio.file.Files.delete;

@Service
public class ProductServiceImpl implements ProductService {


    final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Optional<ProductModel> findById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }


    @Override
    public Optional<ProductModel> findByNameProduct(String nameProduct) {
        return productRepository.findByNameProduct(nameProduct);
    }

    @Override
    public Object deleteById(UUID id) {
        Optional<ProductModel> productModelOptional = findById(id);
        if (!productModelOptional.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao existente.");
        delete(productModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
    }

    @Override
    public void delete(ProductModel productModel) {
        productRepository.delete(productModel);
    }

    @Override
    public List<ProductModel> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Object save(ProductModel name_product) {
        return productRepository.save(name_product);
    }


    @Override
    public Object updateById(UUID id, ProductDto productDto) {
        Optional<ProductModel> productModelOptional=findById(id);
        if (!productModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao existe.");
        }
        ProductModel productModel= productModelOptional.get();
        productModel.setNameProduct(productDto.getNameProduct());
        productModel.setProductPrice(productDto.getProductPrice());
        productModel.setStoreName(productDto.getStoreName());
        productModel.setProductsQuantity(productDto.getProductsQuantity());
        return ResponseEntity.status(HttpStatus.OK).body("Produto atualizado com suesso.");
    }
}
