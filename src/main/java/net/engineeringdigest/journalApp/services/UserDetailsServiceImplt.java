package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.repositories.user_repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class UserDetailsServiceImplt implements UserDetailsService{
    @Autowired
    private user_repositories user_repositories;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = user_repositories.findByUsername(name);
        if(user!=null){
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRoles().toArray(new String[0]))
                    .build();
        }
        throw  new UsernameNotFoundException("user not found"+ name);

}

}
