package com.eauction.app.service;

import com.eauction.app.exception.ResourceNotFoundException;
import com.eauction.app.model.Product;
import com.eauction.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private SequenceGeneratorService sequenceGenerator;


    @Override
    public Product createProduct(Product product) {
    	product.setId(sequenceGenerator.generateSequence(Product.SEQUENCE_NAME));
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional< Product > productDb = this.productRepository.findById(product.getId());

        if (productDb.isPresent()) {
            Product productUpdate = productDb.get();
            productUpdate.setId(sequenceGenerator.generateSequence(Product.SEQUENCE_NAME));
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + product.getId());
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {

        Optional < Product > productDb = this.productRepository.findById(productId);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }

    @Override
    public void deleteProduct(long productId) {
        Optional < Product > productDb = this.productRepository.findById(productId);

        if (productDb.isPresent()) {
            this.productRepository.delete(productDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }

    }
}
