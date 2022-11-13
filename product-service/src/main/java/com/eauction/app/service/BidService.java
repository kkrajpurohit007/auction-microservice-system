package com.eauction.app.service;

import com.eauction.app.exception.ResourceNotFoundException;
import com.eauction.app.model.ProductBid;
import com.eauction.app.repository.ProductBidRepository;
import com.eauction.app.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidService implements IBidService {

	@Autowired
    private ProductRepository productRepository;
    
	@Autowired
    private ProductBidRepository productBidRepository;

    @Override
    public ProductBid createBid(ProductBid productBid) {
        Optional<List<ProductBid>> productBidData = this.productBidRepository.findProductBidsByProductIdAndBuyerId(
                productBid.getProductId(),
                productBid.getBuyerId()
        );
        if (productBidData.get().isEmpty()) {
        	productBid.getId();
            return productBidRepository.save(productBid);
        } else {
            throw new ResourceNotFoundException("Record already found : " + productBid.getProductId());
        }
    }

    @Override
    public ProductBid updateBid(ProductBid productBid) {
        Optional<ProductBid> productBidData = this.productBidRepository.findById(productBid.getId());
        if (productBidData.isPresent()) {
            ProductBid productBidUpdate = productBidData.get();
            productBidUpdate.setBidAmount(productBid.getBidAmount());
            productBidRepository.save(productBidUpdate);
            return productBidUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productBid.getProductId());
        }
    }

    @Override
    public List<ProductBid> getBidByProductId(long productId) {
        Optional<List<ProductBid>> productBidsOpt = Optional.ofNullable(this.productBidRepository.findProductBidsByProductId(productId));
        if (productBidsOpt.isPresent()) {
            return productBidsOpt.get();
        } else {
            throw new ResourceNotFoundException("Record not found with  : " + productId);
        }
    }

    @Override
    public ProductBid getBidById(long id) {
        Optional <ProductBid> productBidDb = this.productBidRepository.findById(id);
        if (productBidDb.isPresent()) {
            return productBidDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public void deleteBid(long id) {
        Optional <ProductBid> productBidDb = this.productBidRepository.findById(id);
        if (productBidDb.isPresent()) {
            this.productBidRepository.delete(productBidDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
}
