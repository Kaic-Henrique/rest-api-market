package com.market.market.controller;


import com.market.market.entity.ProductEntity;
import com.market.market.repository.ProductRepository;
import com.market.market.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

     private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> findAll(){
        List<ProductEntity> products = productService.findProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductEntity> findById(@PathVariable Long id){
        ProductEntity findProduct = productService.findProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(findProduct);
    }

    @PostMapping("/registerProduct")
    public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity productEntity){
        ProductEntity registerProduct = productService.registerProduct(productEntity);
        return ResponseEntity.status(HttpStatus.OK).body(registerProduct);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<ProductEntity> update(@PathVariable Long id, @RequestBody ProductEntity productEntity){
        ProductEntity updateProduct = productService.atualizarRegistro(id, productEntity);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }


    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
