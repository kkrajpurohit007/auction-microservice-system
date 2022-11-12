package com.eauction.app.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;


@Data
@Document(collection="buyer")
public class Buyer {
	@MongoId
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String pin;
    @Indexed(unique = true)
    private String phone;
    @Indexed(unique = true)
    private String email;

//    private Integer productId;
//    private Float bidAmount;
}
