package com.api.product.controler.v1;


import com.api.product.domain.model.v1.ProductModel;
import com.api.product.dto.v1.ProductDto;
import com.api.product.service.v1.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/product/v1")
@CrossOrigin(origins = "*")
public class ProductControler {

    final ProductService productService;

    public ProductControler(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto productDto) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productDto,productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productService.save(productModel));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ProductModel> getById(@PathVariable(value = "id")UUID id){
        Optional<ProductModel> productModelOptional=productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productModelOptional.get());
    }

    // precisa pegar os produtos disponivel

    @GetMapping("/getByName/{nameProduct}")
    public ResponseEntity<Object> getByNameProduct(@PathVariable(value = "nameProduct")String nameProduct){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findByNameProduct(nameProduct));
    }
    @PutMapping("/updateById/{id}")
    public ResponseEntity<Object> updateById(@PathVariable(value = "id")UUID id,@RequestBody ProductDto productDto){
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateById(id,productDto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Object>deleteById(@PathVariable(value = "id")UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteById(id));
    }
}
