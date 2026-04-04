package com.cg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.ProductDto;
import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;
import com.cg.repository.ProductRepo;

@Service
public class ProductService implements ProductServiceI{

    @Autowired
    private ProductRepo repo;

    public Product addProduct(ProductDto dto) {
        Product product = mapToEntity(dto);
        return repo.save(product);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product updateProduct(ProductDto dto) {
        Product existing = repo.findById(dto.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        existing.setProductName(dto.getProductName());
        existing.setPrice(dto.getPrice());
        existing.setCategory(dto.getCategory());

        return repo.save(existing);
    }

    private Product mapToEntity(ProductDto dto) {
        Product p = new Product();
        p.setProductId(dto.getProductId());
        p.setProductName(dto.getProductName());
        p.setPrice(dto.getPrice());
        p.setCategory(dto.getCategory());
        return p;
    }
}