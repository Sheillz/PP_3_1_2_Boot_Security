package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.userRoles")
    List<User> findAllWithRoles();

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.userRoles WHERE u.id = :userId")
    User findByIdWithRoles(Integer userId);
}
