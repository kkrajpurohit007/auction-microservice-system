package com.eauction.app.wrapper;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProductBid {
    private long id;
    private Long productId;
    private Long buyerId;
    private Double bidAmount;
    private LocalDate bidDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
