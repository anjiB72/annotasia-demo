package com.chapter.backend.customannotations.repository;

import com.chapter.backend.customannotations.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserJpaRepository extends JpaRepository<User, Long> {

}
