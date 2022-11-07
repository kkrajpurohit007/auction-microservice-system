package com.eauction.app.repository;

import com.eauction.app.model.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepository extends MongoRepository<Seller, Long> {

}
