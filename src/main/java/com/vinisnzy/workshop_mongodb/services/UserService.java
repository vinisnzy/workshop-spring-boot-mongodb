package com.vinisnzy.workshop_mongodb.services;

import com.vinisnzy.workshop_mongodb.domain.User;
import com.vinisnzy.workshop_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
