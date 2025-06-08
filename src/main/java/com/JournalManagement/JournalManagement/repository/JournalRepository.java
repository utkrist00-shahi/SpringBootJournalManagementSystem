package com.JournalManagement.JournalManagement.repository;

import com.JournalManagement.JournalManagement.model.JournalEntry;
import com.JournalManagement.JournalManagement.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<JournalEntry, ObjectId> {
}
