package com.market.market.controller;


import com.market.market.entity.ProductEntity;
import com.market.market.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> findAll(){
        List<ProductEntity> products = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductEntity> findById(@PathVariable Long id){
        ProductEntity findProduct = productRepository.findById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(findProduct);
    }

    @PostMapping("/registerProduct")
    public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity productEntity){
        ProductEntity registerProduct = productRepository.save(productEntity);
        return ResponseEntity.status(HttpStatus.OK).body(registerProduct);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
