package com.JournalManagement.JournalManagement.controller;

import com.JournalManagement.JournalManagement.model.JournalEntry;
import com.JournalManagement.JournalManagement.model.User;
import com.JournalManagement.JournalManagement.repository.UserRepository;
import com.JournalManagement.JournalManagement.service.JournalService;
import com.JournalManagement.JournalManagement.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journals")
public class JournalController {

    @Autowired
    private JournalService journalService;
    @Autowired
    private UserService userService;

    @PostMapping("{Name}")
    public ResponseEntity<?> addJournal(@RequestBody JournalEntry journalEntry,@PathVariable String Name){
        try{
            User user = userService.findUserByName(Name);
            journalService.addJournals(journalEntry, Name);
            return new ResponseEntity<>(journalEntry, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("{Name}")
    public ResponseEntity<?> getAllJournals(@PathVariable String Name){

        User user = userService.findUserByName(Name);
        List<JournalEntry> jour = user.getJournalEntries();
        if(jour != null){

            return new ResponseEntity<>(jour,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalById(@PathVariable ObjectId myId){
       return  journalService.findJournalById(myId).orElse(null);
    }

    @DeleteMapping("id/{userName}/{myId}")
    public boolean deleteJournalById(@PathVariable ObjectId myId, @PathVariable String userName){
        journalService.deleteJournalById(myId, userName);
       return true;
    }

    @PutMapping("{myId}")
    public JournalEntry updateJournalById(@PathVariable ObjectId myId, @RequestBody JournalEntry journalEntry){
        return journalService.updateJournalControllerbyId(journalEntry, myId);
    }

}
