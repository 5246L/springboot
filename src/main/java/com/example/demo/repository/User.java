package com.example.demo.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity // указание на то, что данный класс (User) является сущностью в бд
@Table(name = "user1") // указание название таблицы которая используется в бд (когда имя класса не совпадает с таблицей в бд)
public class User {

    @Id // говорим, что данная переменная primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // указание на то, что ID генерирует сама бд(IDENTITY)
    private Long id;
//    @Column(name = "name") - использовать тогда, когда название колонки в таблице и в бд отличаются
    private String name;
    private String email;
    private LocalDate birth;
    private Integer age;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", age=" + age +
                '}';
    }
}
