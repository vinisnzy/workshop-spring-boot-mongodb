package com.vinisnzy.workshop_mongodb.services;

import com.vinisnzy.workshop_mongodb.domain.User;
import com.vinisnzy.workshop_mongodb.dto.UserDTO;
import com.vinisnzy.workshop_mongodb.repository.UserRepository;
import com.vinisnzy.workshop_mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new ObjectNotFoundException("User not found");
        }
        return user.get();
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }

    public User update(User user) {
        User existingUser = findById(user.getId());
        updateData(existingUser, user);
        return repository.save(existingUser);
    }

    private void updateData(User other, User user) {
        other.setName(user.getName());
        other.setEmail(user.getEmail());
    }
}
