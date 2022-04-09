package com.example.demo.controllers;

import com.example.demo.entities.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UsersController {

    Map<Integer, UserEntity> users = new HashMap<>();

    @GetMapping("/users")
    public ResponseEntity<Map<Integer, UserEntity>> getUsers() {
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}/get")
    public ResponseEntity<UserEntity> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(users.get(id));
    }

    @GetMapping("/users/{id}/remove")
    public ResponseEntity<UserEntity> removeUser(@PathVariable Integer id) {
        UserEntity user = users.get(id);
        users.remove(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/add")
    public ResponseEntity<UserEntity> addUser(@RequestParam Integer id,
                                              @RequestParam String name,
                                              @RequestParam String surname) {
        UserEntity user = new UserEntity(name,surname);
        users.put(id,user);
        return ResponseEntity.ok(user);
    }
}
