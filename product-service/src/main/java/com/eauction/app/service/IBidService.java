package com.eauction.app.service;

import com.eauction.app.model.Product;
import com.eauction.app.model.ProductBid;

import java.util.List;

public interface IBidService {
    ProductBid createBid(ProductBid productBid);

    ProductBid updateBid(ProductBid productBid);

    List<ProductBid> getBidByProductId(long productId);

    ProductBid getBidById(long id);

    void deleteBid(long id);
}
