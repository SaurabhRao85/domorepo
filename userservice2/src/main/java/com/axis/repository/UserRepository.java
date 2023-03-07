package com.axis.repository;

import java.util.List;
import java.util.Optional;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.axis.dto.UserDto;
import com.axis.model.User;

public interface UserRepository extends MongoRepository<User, ObjectId>{

	@Query("{phoneNumber:?0}")
	Optional<User> findByPhoneNumber(long phoneNumber);

	@Query("{holderName:?0}")
	Optional<User> findByHolderName(String holderName);

	@Query("{city:?0}")
	Optional<User> findByCity(String city);

	UserDto save(UserDto userDto);
	

	
	

}
