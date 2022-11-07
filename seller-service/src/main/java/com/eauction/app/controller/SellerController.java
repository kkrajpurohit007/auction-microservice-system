package com.eauction.app.controller;

import com.eauction.app.model.Seller;
import com.eauction.app.service.SellerService;
import com.eauction.app.wrapper.Product;
import com.eauction.app.wrapper.RequestWrapper;
import com.eauction.app.wrapper.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("e-auction/api/v1")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @PostMapping("/seller/add-product")
    public ResponseEntity <ResponseWrapper> createSellerProduct(@RequestBody RequestWrapper requestData) {
        Product product = requestData.getProduct();
        Seller seller = requestData.getSeller();
        // TODO : REST-Template Save Product by calling product service
        // TODO: Save Seller information if product save successful
        ResponseWrapper responseWrapper = new ResponseWrapper();
        return ResponseEntity.ok(responseWrapper);
    }

    @DeleteMapping("/seller/delete/{id}")
    public HttpStatus deleteSellerProduct(@PathVariable long id) {
        // TODO: Auth Product & seller authentication
        // TODO : call product delete service
        return HttpStatus.OK;
    }

    @GetMapping("seller/show-bids/{id}")
    public ResponseEntity<ResponseWrapper> showProductBidList(@PathVariable long id){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        // TODO : Verify product Exist or not
        // TODO : Fetch Product Bid list
        return ResponseEntity.ok(responseWrapper);
    }

    @GetMapping("/sellers")
    public ResponseEntity <List<Seller>> getAllSeller() {
        return ResponseEntity.ok().body(sellerService.getAllSeller());
    }

    @GetMapping("/seller/{id}")
    public ResponseEntity <Seller> getSellerById(@PathVariable long id) {
        return ResponseEntity.ok().body(sellerService.getSellerById(id));
    }

    @PostMapping("/seller")
    public ResponseEntity <Seller> createSeller(@RequestBody Seller seller) {
        return ResponseEntity.ok().body(this.sellerService.createSeller(seller));
    }

    @PutMapping("/seller/{id}")
    public ResponseEntity <Seller> updateSeller(@PathVariable long id, @RequestBody Seller seller) {
        seller.setId(id);
        return ResponseEntity.ok().body(this.sellerService.updateSeller(seller));
    }

    @DeleteMapping("/seller/{id}")
    public HttpStatus deleteSeller(@PathVariable long id) {
        this.sellerService.deleteSeller(id);
        return HttpStatus.OK;
    }
}
