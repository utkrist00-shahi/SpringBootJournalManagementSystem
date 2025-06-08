package com.JournalManagement.JournalManagement.service;

import com.JournalManagement.JournalManagement.model.JournalEntry;
import com.JournalManagement.JournalManagement.model.User;
import com.JournalManagement.JournalManagement.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserService userService;


    public void addJournals(JournalEntry journalEntry, String userName){
        User user = userService.findUserByName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.addusers(user);
    }

    public List<JournalEntry> findJournals(){
        return new ArrayList<>(journalRepository.findAll());
    }

    public Optional<JournalEntry> findJournalById(ObjectId id){
        return journalRepository.findById(id);
    }
    public void deleteJournalById(ObjectId id, String userName){
        User user = userService.findUserByName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.addusers(user);
        journalRepository.deleteById(id);
    }

}
