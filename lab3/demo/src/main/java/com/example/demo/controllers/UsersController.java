package com.example.demo.controllers;

import com.example.demo.entities.UserEntity;
import com.example.demo.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Controller
@Validated
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public ResponseEntity<Page<UserEntity>> getUsersPaginated(
            @RequestParam(name = "page-number", defaultValue = "1") @Min(1) int pageNumber,
            @RequestParam(name = "page-size",defaultValue = "1") @Min(1) @Max(100) int pageSize) {
        return ResponseEntity.ok(userService.getUsersPaginated(pageNumber,pageSize));
    }

    @GetMapping("/api/users/add")
    public ResponseEntity<List<UserEntity>> addUsers() {
        return ResponseEntity.ok(userService.addUsers());
    }

}
