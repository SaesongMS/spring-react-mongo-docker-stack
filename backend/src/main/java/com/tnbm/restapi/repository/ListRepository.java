package com.tnbm.restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tnbm.restapi.models.UserList;

public interface ListRepository extends MongoRepository<UserList, String> {
}
