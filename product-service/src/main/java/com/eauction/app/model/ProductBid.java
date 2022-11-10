package com.eauction.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="ProductBid")
public class ProductBid {
    @Id
    private long id;
}
