package com.chapter.backend.customannotations.service;

import com.chapter.backend.customannotations.model.User;
import com.chapter.backend.customannotations.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userJpaRepository;

    public User saveUser(User user) {
        return userJpaRepository.save(user);
    }

    public User getUserById(Long id) {
        User user = userJpaRepository.getReferenceById(id);
        user.setPassword(null);
        return user;
    }
}
