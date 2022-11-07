package com.eauction.app.service;

import com.eauction.app.model.Seller;

import java.util.List;

public interface ISellerService {

    Seller createSeller(Seller seller);

    Seller updateSeller(Seller seller);

    List<Seller> getAllSeller();

    Seller getSellerById(long Id);

    void deleteSeller(long id);
}
