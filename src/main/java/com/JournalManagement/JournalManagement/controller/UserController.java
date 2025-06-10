package com.JournalManagement.JournalManagement.controller;

import com.JournalManagement.JournalManagement.model.JournalEntry;
import com.JournalManagement.JournalManagement.model.User;
import com.JournalManagement.JournalManagement.repository.UserRepository;
import com.JournalManagement.JournalManagement.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public boolean addUsers(@RequestBody User user){
        userService.addusers(user);
        return true;
    }

    @GetMapping
    public List<User> findUsers(){
        return userService.findUsers();
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteUserById(@PathVariable ObjectId myId){
        userService.deleteUsersById(myId);
        return true;
    }
    @PutMapping("/{userName}")
    public ResponseEntity<User> updateUsers(@RequestBody User user, @PathVariable String userName){
        User userInDb = userService.findUserByName(userName);
        if(userInDb != null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.addusers(userInDb);
            return  new ResponseEntity<>(userInDb,HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("{userName}")
    public User getUserByName(@PathVariable String userName){
        return userService.findUserByName(userName);
    }
}
