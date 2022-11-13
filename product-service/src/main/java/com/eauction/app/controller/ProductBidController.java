package com.eauction.app.controller;

import com.eauction.app.model.Product;
import com.eauction.app.model.ProductBid;
import com.eauction.app.service.BidService;
import com.eauction.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("e-auction/api/v1")
public class ProductBidController {

    @Autowired
    private BidService bidService;

    @GetMapping("/bids/product/{productId}")
    public ResponseEntity<List<ProductBid>> getBidByProductId(@PathVariable long productId) {
        return ResponseEntity.ok().body(bidService.getBidByProductId(productId));
    }

    @GetMapping("/products/{id}/bids")
    public ResponseEntity <ProductBid> getBid(@PathVariable long id) {
        return ResponseEntity.ok().body(bidService.getBidById(id));
    }

    @PostMapping("/bid")
    public ResponseEntity < ProductBid > createProduct(@RequestBody ProductBid productBid) {
        return ResponseEntity.ok().body(this.bidService.createBid(productBid));
    }

    @PutMapping("/bid/{id}")
    public ResponseEntity <ProductBid> updateProductBid(@PathVariable long id, @RequestBody ProductBid productBid) {
        productBid.setId(id);
        return ResponseEntity.ok().body(this.bidService.updateBid(productBid));
    }

    @DeleteMapping("/bid/{id}")
    public HttpStatus deleteProductBid(@PathVariable long id) {
        this.bidService.deleteBid(id);
        return HttpStatus.OK;
    }



}
