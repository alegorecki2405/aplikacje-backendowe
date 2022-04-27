package com.example.demo.services;

import com.example.demo.entities.UserEntity;
import com.example.demo.repo.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<UserEntity> getUsersPaginated(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize);
        return userRepository.findAll(pageRequest);
    }

    public List<UserEntity> addUsers() {
        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity("olek","gorecki"));
        users.add(new UserEntity("staszek","srarczyk"));
        users.add(new UserEntity("wika","springer"));
        return userRepository.saveAllAndFlush(users);
    }
}
