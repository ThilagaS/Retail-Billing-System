package com.retail.billing.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.retail.billing.entity.ProductEntity;

public interface  BillingRepository  extends  MongoRepository<ProductEntity, String>{

	List<ProductEntity> findByItemType(String itemType);

}
