package com.eauction.app.service;

import com.eauction.app.model.Buyer;

import java.util.List;

public interface IBuyerService {

    Buyer createBuyer(Buyer buyer);

    Buyer updateBuyer(Buyer buyer);

    List<Buyer> getAllBuyer();

    Buyer getBuyerById(long Id);

    void deleteBuyer(long id);
}
