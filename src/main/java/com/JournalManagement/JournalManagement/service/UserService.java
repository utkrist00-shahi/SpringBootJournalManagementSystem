package com.JournalManagement.JournalManagement.service;

import com.JournalManagement.JournalManagement.model.JournalEntry;
import com.JournalManagement.JournalManagement.model.User;
import com.JournalManagement.JournalManagement.repository.JournalRepository;
import com.JournalManagement.JournalManagement.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ResponseEntity<?> addusers(User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public List<User> findUsers(){
        return new ArrayList<>(userRepository.findAll());
    }
    public User findUserByName(String username){
        return userRepository.findUserByUserName(username);
    }
    public void deleteUsersById(ObjectId id){

        userRepository.deleteById(id);
    }


}
