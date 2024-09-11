package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.repositories.user_repositories;
import net.engineeringdigest.journalApp.services.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class Public {
    @Autowired
    public UserEntryService user_entry;

    @Autowired
    public user_repositories user_repositories;



        @GetMapping("/health-check")
        public String health(){
            return "ok";
        }


        @PostMapping("create-user")
        public void create_user(@RequestBody User user){

            user_entry.saveEntryEncrypt(user);
        }



    }

