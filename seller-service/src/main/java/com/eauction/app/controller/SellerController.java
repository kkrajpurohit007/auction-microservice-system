package com.eauction.app.controller;

import com.eauction.app.model.Seller;
import com.eauction.app.service.SellerService;
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
