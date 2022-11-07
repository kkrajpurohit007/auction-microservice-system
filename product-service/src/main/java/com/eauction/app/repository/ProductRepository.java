package com.eauction.app.repository;

import com.eauction.app.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long> {

}
