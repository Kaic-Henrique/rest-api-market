package com.market.market.service;

import com.market.market.entity.ProductEntity;
import com.market.market.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<ProductEntity> findProducts(){
        return productRepository.findAll();
    }

    public ProductEntity findProduct(Long id){
        return productRepository.findById(id).get();
    }

    public ProductEntity registerProduct(ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
