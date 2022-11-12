package com.eauction.app.service;

import java.util.List;

import com.eauction.app.model.ProductBid;

public interface IBidService {
    ProductBid createBid(ProductBid productBid);

    ProductBid updateBid(ProductBid productBid);

    List<ProductBid> getBidByProductId(long productId);

    ProductBid getBidById(long id);

    void deleteBid(long id);
}
