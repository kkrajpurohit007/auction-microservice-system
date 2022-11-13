package com.eauction.app.wrapper;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Product {
    private long id;
    private String name;
    private String description;
    private String shortDescription;
    private String category;
    private Double startingPrice;
    private Date bidEndDate;
    private Long sellerId;
}
