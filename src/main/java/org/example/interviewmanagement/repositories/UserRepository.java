package org.example.interviewmanagement.repositories;

import org.example.interviewmanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
//    @Query(value = "SELECT u FROM User u where u.")
    User findByUsername(String username);
}
