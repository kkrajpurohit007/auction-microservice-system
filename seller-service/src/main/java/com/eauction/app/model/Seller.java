package com.eauction.app.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document(collection = "SellerDB")
public class Seller {
	
	@Transient
    public static final String SEQUENCE_NAME = "seller_sequence";
	
	@MongoId
	private long id;
	@Indexed(unique = true)
	
	@NotEmpty(message = "The first name is required.")
	@Size(min = 5, max = 30, message = "The length of first name must be between 5 and 30 characters.")
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String pin;
	@NotNull
	@Digits(message = "Please enter a valid phone number", fraction = 0, integer = 10)
	private String phone;
	
	@NotEmpty(message = "The email address is required.")
	@Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
	private String email;

}
