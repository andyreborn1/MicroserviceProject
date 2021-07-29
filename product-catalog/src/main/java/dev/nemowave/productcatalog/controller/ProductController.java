package dev.nemowave.productcatalog.controller;

import dev.nemowave.productcatalog.model.Product;
import dev.nemowave.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    Iterable<Product> list(){
        return productRepository.findAll();
    }
}
