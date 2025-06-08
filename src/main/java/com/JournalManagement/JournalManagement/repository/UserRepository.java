package com.JournalManagement.JournalManagement.repository;

import com.JournalManagement.JournalManagement.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

   User findByUserName(String name);
}
