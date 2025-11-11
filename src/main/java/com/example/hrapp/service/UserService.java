package com.example.hrapp.service;

import com.example.hrapp.model.User;
import com.example.hrapp.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }
    public List<User> getAllUsers(){
        return repo.findAll();
    }
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        );
    }

    public User createUser(User user) {
        return repo.save(user);
    }
}
