package com.chapter.backend.customannotations.controller;

import com.chapter.backend.customannotations.model.User;
import com.chapter.backend.customannotations.repository.UserJpaRepository;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserJpaRepository userJpaRepository;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody @Valid User user) {

        User newUser = userJpaRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(newUser.getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userJpaRepository.getReferenceById(Long.parseLong(id));
        return ResponseEntity.ok(user);
    }

}
