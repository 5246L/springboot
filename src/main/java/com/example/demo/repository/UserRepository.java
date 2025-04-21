package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

// передаем класс с которым работаем и тип id
public interface UserRepository extends JpaRepository<User, Long> {

    // 1 вариант на нативном sql
    @Query(value = "select * from user1  where email = :email", nativeQuery = true)
    // если названия (email) разные, то нужно использоваться аннотацию @Param(value = "email")
                        Optional <User> findByEmail(String email);

    // 2 вариант
//    @Query(value = "select u from User u where u.email = :email")
//
//    User findByEmail(@Param(value = "email") String email);

//    // 3 вариант
//    User findByEmailAndAgeAfterAndBirth(String email, Integer age, LocalDate birth);
}
