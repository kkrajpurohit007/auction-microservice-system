package com.eauction.app.service;

import com.eauction.app.exception.ResourceNotFoundException;
import com.eauction.app.model.Buyer;
import com.eauction.app.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BuyerService implements IBuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public Buyer createBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public Buyer updateBuyer(Buyer buyer) {
        Optional< Buyer > buyerDb = this.buyerRepository.findById(buyer.getId());

        if (buyerDb.isPresent()) {
            Buyer buyerUpdate = buyerDb.get();
            buyerUpdate.setId(buyer.getId());
            buyerUpdate.setName(buyer.getName());
            buyerUpdate.setDescription(buyer.getDescription());
            buyerRepository.save(buyerUpdate);
            return buyerUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + buyer.getId());
        }
    }

    @Override
    public List<Buyer> getAllBuyer() {
        return this.buyerRepository.findAll();
    }

    @Override
    public Buyer getBuyerById(long Id) {

        Optional <Buyer> buyerDb = this.buyerRepository.findById(Id);

        if (buyerDb.isPresent()) {
            return buyerDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Id);
        }
    }

    @Override
    public void deleteBuyer(long Id) {
        Optional <Buyer> buyerDb = this.buyerRepository.findById(Id);

        if (buyerDb.isPresent()) {
            this.buyerRepository.delete(buyerDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Id);
        }

    }
}
