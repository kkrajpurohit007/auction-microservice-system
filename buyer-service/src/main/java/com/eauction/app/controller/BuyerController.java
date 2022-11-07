package com.eauction.app.controller;

import com.eauction.app.model.Buyer;
import com.eauction.app.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("e-auction/api/v1")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @GetMapping("/buyers")
    public ResponseEntity <List<Buyer>> getAllBuyer() {
        return ResponseEntity.ok().body(buyerService.getAllBuyer());
    }

    @GetMapping("/buyers/{id}")
    public ResponseEntity <Buyer> getBuyerById(@PathVariable long id) {
        return ResponseEntity.ok().body(buyerService.getBuyerById(id));
    }

    @PostMapping("/buyers")
    public ResponseEntity <Buyer> createBuyer(@RequestBody Buyer buyer) {
        return ResponseEntity.ok().body(this.buyerService.createBuyer(buyer));
    }

    @PutMapping("/buyers/{id}")
    public ResponseEntity <Buyer> updateBuyer(@PathVariable long id, @RequestBody Buyer buyer) {
        buyer.setId(id);
        return ResponseEntity.ok().body(this.buyerService.updateBuyer(buyer));
    }

    @DeleteMapping("/buyers/{id}")
    public HttpStatus deleteBuyer(@PathVariable long id) {
        this.buyerService.deleteBuyer(id);
        return HttpStatus.OK;
    }
}
