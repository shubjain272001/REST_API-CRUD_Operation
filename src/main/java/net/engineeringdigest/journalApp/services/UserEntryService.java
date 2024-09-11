package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.repositories.user_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserEntryService {

    @Autowired
    public user_repositories repo;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveEntry(User user){
        repo.save(user);
    }

    public void saveEntryEncrypt(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        repo.save(user);
    }

    public List<User> get_entry(){
        return repo.findAll();
    }

    public User findByUsername(String username){
        return repo.findByUsername(username);

    }


}


