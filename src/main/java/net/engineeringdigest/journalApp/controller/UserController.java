package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.repositories.user_repositories;
import net.engineeringdigest.journalApp.services.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserEntryService user_entry;

    @Autowired
    public user_repositories user_repositories;

    @GetMapping
    public List<User> get_users(){
        return user_entry.get_entry();
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user ) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User olduser = user_entry.findByUsername(username);
        olduser.setUsername(user.getUsername());
        olduser.setAge(user.getAge());
        olduser.setPassword(user.getPassword());
        user_entry.saveEntryEncrypt(olduser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(){
        Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
        user_repositories.deleteByUsername(authentication1.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
