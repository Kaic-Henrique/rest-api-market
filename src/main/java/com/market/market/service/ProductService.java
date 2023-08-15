package com.market.market.service;

import com.market.market.entity.ProductEntity;
import com.market.market.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    ProductRepository productRepository;


    public List<ProductEntity> findProducts(){
        return productRepository.findAll();
    }

    public ProductEntity findProduct(Long id){
        return productRepository.findById(id).get();
    }

    public ProductEntity registerProduct(ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

    public ProductEntity atualizarRegistro(Long id, ProductEntity newProduct){
        ProductEntity currentProduct = productRepository.findById(id).get();
        BeanUtils.copyProperties(newProduct,currentProduct,"id");
        return productRepository.save(currentProduct);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
