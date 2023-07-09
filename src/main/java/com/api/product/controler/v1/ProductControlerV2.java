package com.api.product.controler.v1;


import com.api.product.domain.model.v1.ProductModel;
import com.api.product.service.v1.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/product/v2")
public class ProductControlerV2 {

    final ProductService productService;


    public ProductControlerV2(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductModel>>getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }
}
