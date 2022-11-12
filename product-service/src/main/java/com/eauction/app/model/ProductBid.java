package com.eauction.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(collection="ProductBid")
public class ProductBid {
    @Id
    private long id;
    private Long productId;
    private Long buyerId;
    private Double bidAmount;
    private LocalDate bidDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
