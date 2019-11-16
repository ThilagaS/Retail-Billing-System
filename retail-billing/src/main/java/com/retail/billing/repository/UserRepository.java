package com.retail.billing.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.retail.billing.entity.UserEntity;

public interface UserRepository extends  MongoRepository<UserEntity, String>{

	Optional<UserEntity> findByUserType(String userType);


}
