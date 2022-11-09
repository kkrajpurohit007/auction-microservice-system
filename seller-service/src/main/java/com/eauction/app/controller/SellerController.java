package com.eauction.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eauction.app.model.Seller;
import com.eauction.app.service.SellerService;
import com.eauction.app.wrapper.Product;
import com.eauction.app.wrapper.RequestWrapper;
import com.eauction.app.wrapper.ResponseWrapper;

@RestController
@RequestMapping("e-auction/api/v1")
public class SellerController {
    @Autowired
    private SellerService sellerService;
    
    @Autowired
    RestTemplate restTemplate;
    
    @PostMapping("/seller/add-product")
    public ResponseEntity <ResponseWrapper> createSellerProduct(@RequestBody RequestWrapper requestData) {
        Product product = requestData.getProduct();
        Seller seller = requestData.getSeller();
        // TODO : REST-Template Save Product by calling product service
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
        Product productEntity =  restTemplate.exchange(
              "http://localhost:8082/e-auction/api/v1/products", HttpMethod.POST, entity, Product.class).getBody();
        // TODO: Save Seller information if product save successful
        
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setProduct(productEntity);
        responseWrapper.setSeller(sellerService.createSeller(seller));
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
