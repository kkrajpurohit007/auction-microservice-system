package com.eauction.app.repository;

import com.eauction.app.model.ProductBid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductBidRepository extends MongoRepository<ProductBid, Long> {
    List<ProductBid> findProductBidsByProductId(Long productId);
}
