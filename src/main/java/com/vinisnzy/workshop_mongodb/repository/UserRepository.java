package com.vinisnzy.workshop_mongodb.repository;

import com.vinisnzy.workshop_mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
