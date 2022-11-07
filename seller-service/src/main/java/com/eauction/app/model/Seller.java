package com.eauction.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection="seller")
public class Seller {
    @Id
    private long id;
    @Indexed(unique = true)
    private String name;
    private String description;
    private String shortDescription;
}
