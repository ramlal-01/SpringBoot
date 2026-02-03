package org.example.productmanagement.controller;

import org.example.productmanagement.service.ProductService;
import org.example.productmanagement.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService service;

    public  ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> products() {
        return service.getProduct();
    }

    @PostMapping("/products")
    public Product productsCreate(@RequestBody Product productModel) {
        return service.addProduct(productModel);
    }

    @PatchMapping("/products/{id}")
    public Product productUpdate(@PathVariable String id, @RequestBody Product productModel) {
        productModel.setId(id);
        return service.updateProduct(productModel);
    }

    @DeleteMapping("/products/{id}")
    public String productDelete(@PathVariable String id) {
        service.deleteProduct(id);
        return "Product deleted successfully";
    }
}