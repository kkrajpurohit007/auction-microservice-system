package com.eauction.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document(collection="ProductBid")
public class ProductBid {
	@MongoId
    private long id;
    private Long productId;
    private Long buyerId;
    private Double bidAmount;
    private LocalDate bidDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
