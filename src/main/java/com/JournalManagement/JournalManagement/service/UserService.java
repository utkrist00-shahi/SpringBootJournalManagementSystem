package com.JournalManagement.JournalManagement.service;

import com.JournalManagement.JournalManagement.model.JournalEntry;
import com.JournalManagement.JournalManagement.model.User;
import com.JournalManagement.JournalManagement.repository.JournalRepository;
import com.JournalManagement.JournalManagement.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addusers(User user){
        userRepository.save(user);
    }

    public List<User> findUsers(){
        return new ArrayList<>(userRepository.findAll());
    }
    public User findUserByName(String username){
        return userRepository.findByUserName(username);
    }
    public void deleteUsersById(ObjectId id){
        userRepository.deleteById(id);
    }


}
