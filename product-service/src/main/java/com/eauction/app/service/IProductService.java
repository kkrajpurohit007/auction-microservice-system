package com.eauction.app.service;

import com.eauction.app.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {

    Product createProduct(Product product);

    Product updateProduct(Product product);

    List<Product> getAllProduct();

    Product getProductById(long productId);

    void deleteProduct(long id);
}
