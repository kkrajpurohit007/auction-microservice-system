package com.eauction.app.wrapper;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class ProductBid {
    private long id;
    private Long productId;
    private Long buyerId;
    private Double bidAmount;
    private LocalDate bidDate;
}
