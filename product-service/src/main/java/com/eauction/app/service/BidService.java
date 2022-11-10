package com.eauction.app.service;

import com.eauction.app.model.Product;
import com.eauction.app.model.ProductBid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService implements IBidService {

    @Override
    public ProductBid createBid(ProductBid productBid) {
        return null;
    }

    @Override
    public ProductBid updateBid(ProductBid productBid) {
        return null;
    }

    @Override
    public List<ProductBid> getBidByProductId(long productId) {
        return null;
    }

    @Override
    public ProductBid getBidById(long id) {
        return null;
    }

    @Override
    public void deleteBid(long id) {

    }
}
