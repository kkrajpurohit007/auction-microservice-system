package com.eauction.app.controller;

import com.eauction.app.config.ProductConfigValues;
import com.eauction.app.model.Product;
import com.eauction.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("e-auction/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    ProductConfigValues productConfigValues;

    @GetMapping("/verison")
    public ResponseEntity <String> getVersion() {
        return ResponseEntity.ok().body(productConfigValues.getBuildVersion());
    }

    @GetMapping("/products")
    public ResponseEntity <List<Product>> getAllProduct() {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity <Product> getProductById(@PathVariable long id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @PostMapping("/products")
    public ResponseEntity < Product > createProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(this.productService.createProduct(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity < Product > updateProduct(@PathVariable long id, @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        this.productService.deleteProduct(id);
        return HttpStatus.OK;
    }
}
