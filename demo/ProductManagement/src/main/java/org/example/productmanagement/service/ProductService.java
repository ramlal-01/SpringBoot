package org.example.productmanagement.service;

import org.example.productmanagement.model.Product;
import org.example.productmanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getProduct(){
        return repository.findAll();
    }
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId())
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        return repository.save(existingProduct);
    }

    public void deleteProduct(String id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));
        repository.delete(product);
    }
}