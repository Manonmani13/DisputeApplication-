package com.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Cacheable(value = "product", key = "#id")
    public Product getProduct(Long id) {
        System.out.println("Fetching from DB");
        return repository.findById(id)
                .orElseThrow();
    }
    
    @CacheEvict(value = "product", key = "#product.id")
    public Product updateProduct(Product product) {
        return repository.save(product);
    }
    
    @CacheEvict(value = "product", key = "#id")
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }


}
