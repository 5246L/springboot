package com.example.demo.controller;

import com.example.demo.repository.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@RestController // указываем спрингу где искать поинты (например класс helloWorld)
@RequestMapping(path = "api/user1") // после "localhost:8080" все методы будут находиться по данному адресу
public class UserController {

    private final UserService userService;
    private final JdbcTemplate jdbcTemplate;

    // Внедрение JdbcTemplate через конструктор
    public UserController(UserService userService, JdbcTemplate jdbcTemplate) {
        this.userService = userService;
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping // указание на то, что нужно вернуть конкретный метод
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PostMapping("/reset")
    public void resetTable() {
        jdbcTemplate.execute("TRUNCATE TABLE user1 RESTART IDENTITY CASCADE");
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable Long id,
                       @RequestParam(required = false) String email,
                       @RequestParam(required = false) String name) {
    userService.update(id, email, name);
    }
}