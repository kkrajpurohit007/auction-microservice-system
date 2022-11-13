package com.eauction.app.repository;

import com.eauction.app.model.ProductBid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductBidRepository extends MongoRepository<ProductBid, Long> {
    List<ProductBid> findProductBidsByProductId(Long productId);
    Optional<List<ProductBid>> findProductBidsByProductIdAndBuyerId(long productId, long buyerId);
}
