package com.wander.covid.service;

import com.wander.covid.model.CustomUserDetails;
import com.wander.covid.model.User;
import com.wander.covid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Optional<User> optionalUser= userRepository.findByName(userName);
        optionalUser.orElseThrow(()->new UsernameNotFoundException("User not found"));
        return optionalUser.map(users->new CustomUserDetails(users)).get();
    }
}
