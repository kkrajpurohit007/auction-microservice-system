package com.eauction.app.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;


@Data
@Document(collection="ProductDB")
public class Product {
	
	@Transient
    public static final String SEQUENCE_NAME = "product_sequence";
	
	@MongoId
    private long id;
    @Indexed(unique = true)
    
    @NotEmpty(message = "The name is required.")
	@Size(min = 5, max = 30, message = "The length of name must be between 5 and 30 characters.")
    private String name;
    private String description;
    private String shortDescription;
    private String category;
    private Double startingPrice;
    private Date bidEndDate;

    private Long sellerId;
}
