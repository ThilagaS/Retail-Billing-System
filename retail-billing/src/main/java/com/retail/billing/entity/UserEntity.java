package com.retail.billing.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "Users")
@Data
public class UserEntity {
	private String itemId;
	private String userType;
	private double discount;
	private String name;
	private String dateOfJoining;
	private String dateOfRegister;

}
