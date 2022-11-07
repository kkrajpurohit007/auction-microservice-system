package com.eauction.app.repository;

import com.eauction.app.model.Buyer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuyerRepository extends MongoRepository<Buyer, Long> {

}
