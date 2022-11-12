package com.eauction.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eauction.app.exception.ResourceNotFoundException;
import com.eauction.app.model.Seller;
import com.eauction.app.repository.SellerRepository;
import com.eauction.app.sequence.SequenceGeneratorService;


@Service
public class SellerService implements ISellerService {
    @Autowired
    private SellerRepository sellerRepository;
    
    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @Override
    public Seller createSeller(Seller seller) {
    	seller.setId(sequenceGenerator.generateSequence(Seller.SEQUENCE_NAME));
        return sellerRepository.save(seller);
    }

    @Override
    public Seller updateSeller(Seller seller) {
        Optional<Seller> sellerDb = this.sellerRepository.findById(seller.getId());

        if (sellerDb.isPresent()) {
            Seller sellerUpdate = sellerDb.get();
            sellerUpdate.setId(seller.getId());
            sellerUpdate.setFirstName(seller.getFirstName());
            sellerUpdate.setLastName(seller.getLastName());
            sellerUpdate.setEmail(seller.getEmail());
            sellerUpdate.setAddress(seller.getAddress());
            sellerUpdate.setCity(seller.getCity());
            sellerUpdate.setState(seller.getState());
            sellerUpdate.setPin(seller.getPin());
            sellerUpdate.setPhone(seller.getPhone());
            sellerRepository.save(sellerUpdate);
            return sellerUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + seller.getId());
        }
    }

    @Override
    public List<Seller> getAllSeller() {
        return this.sellerRepository.findAll();
    }

    @Override
    public Seller getSellerById(long sellerId) {

        Optional <Seller> sellerDb = this.sellerRepository.findById(sellerId);

        if (sellerDb.isPresent()) {
            return sellerDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + sellerId);
        }
    }

    @Override
    public void deleteSeller(long sellerId) {
        Optional <Seller> sellerDb = this.sellerRepository.findById(sellerId);

        if (sellerDb.isPresent()) {
            this.sellerRepository.delete(sellerDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + sellerId);
        }

    }
}
