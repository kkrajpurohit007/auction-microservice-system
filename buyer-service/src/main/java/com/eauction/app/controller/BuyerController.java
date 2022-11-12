package com.eauction.app.controller;

import com.eauction.app.model.Buyer;
import com.eauction.app.service.BuyerService;
import com.eauction.app.wrapper.RequestWrapper;
import com.eauction.app.wrapper.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("e-auction/api/v1")
public class BuyerController {

    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @PostMapping("/buyer/place-bid")
    public ResponseEntity <ResponseWrapper> placeProductBid(@RequestBody RequestWrapper requestData) {
        // TODO: Product Exist or Bid Date Start Not expire
        // TODO : CAll product bid insert service
        ResponseWrapper responseWrapper = new ResponseWrapper();
        return ResponseEntity.ok(responseWrapper);
    }

    @GetMapping ("/buyer/update-bid/{productId}/{buyerEmail}/{newBidAmount}")
    public ResponseEntity <ResponseWrapper> updateProductBid(@RequestBody RequestWrapper requestData) {
        // TODO: Product Exist or Bid Date not Expire
        // TODO : CAll product bid update service
        ResponseWrapper responseWrapper = new ResponseWrapper();
        return ResponseEntity.ok(responseWrapper);
    }
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
