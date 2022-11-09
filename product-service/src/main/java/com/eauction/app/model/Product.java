package com.eauction.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Document(collection="ProductDB")
public class Product {
    @Id
    private long id;
    @Indexed(unique = true)
    
    @NotNull(message = "Name may not be null")
    @Size(min=5, max=30)
    private String name;
    private String description;
    private String shortDescription;
    private String category;
    private Double startingPrice;
    private Date bidEndDate;
}
