package com.vinisnzy.workshop_mongodb.services;

import com.vinisnzy.workshop_mongodb.domain.Post;
import com.vinisnzy.workshop_mongodb.repository.PostRepository;
import com.vinisnzy.workshop_mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        if (post.isEmpty()) {
            throw new ObjectNotFoundException("Post not found");
        }
        return post.get();
    }

    public List<Post> findByTitle(String text) {
        List<Post> posts = repository.findByTitle(text);
        if (posts.isEmpty()) {
            throw new ObjectNotFoundException("No posts found with the given title");
        }
        return posts;
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        List<Post> posts = repository.fullSearch(text, minDate, maxDate);
        if (posts.isEmpty()) {
            throw new ObjectNotFoundException("No posts found with the given criteria");
        }
        return posts;
    }
}
