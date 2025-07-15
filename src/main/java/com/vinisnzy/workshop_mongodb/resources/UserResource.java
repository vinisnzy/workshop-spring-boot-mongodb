package com.vinisnzy.workshop_mongodb.resources;

import com.vinisnzy.workshop_mongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User vinicius = new User("1", "Vinicius", "vinicius@gmail.com");
        User maria = new User("2", "Maria", "maria@gmail.com");
        return ResponseEntity.ok().body(Arrays.asList(vinicius, maria));
    }

}
