package com.vinisnzy.workshop_mongodb.config;

import com.vinisnzy.workshop_mongodb.domain.Post;
import com.vinisnzy.workshop_mongodb.domain.User;
import com.vinisnzy.workshop_mongodb.dto.AuthorDTO;
import com.vinisnzy.workshop_mongodb.dto.CommentDTO;
import com.vinisnzy.workshop_mongodb.repository.PostRepository;
import com.vinisnzy.workshop_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        postRepository.deleteAll();
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, dateFormat.parse("15/07/2025"), "Partiu viagem", "Vou viajar para São Paulo, abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, dateFormat.parse("18/07/2025"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO comment1 = new CommentDTO("Boa viagem mano!", dateFormat.parse("15/07/2025"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite!", dateFormat.parse("16/07/2025"), new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", dateFormat.parse("18/07/2025"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
