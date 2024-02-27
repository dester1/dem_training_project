package com.training.exam.service;

import com.training.exam.model.Role;
import com.training.exam.model.User;
import com.training.exam.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public User getByLogin(String login) {return userRepo.findByLogin(login);}

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        userRepo.save(user);
    }
}
