package com.bosco.dummyrest.controllers;

import com.bosco.dummyrest.entities.PostEntity;
import com.bosco.dummyrest.services.PostService;
import com.bosco.dummyrest.vo.PostVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/{id}")
    public PostVO getPost(@PathVariable int id) {
        PostVO post = postService.getPostById(id);

        return post;
    }

    @GetMapping("/posts")
    public ResponseEntity<?> getAllPosts() throws JsonProcessingException {
        List<PostEntity> posts = postService.getAllPosts();

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/posts")
    public PostVO createPost() {
        PostVO p = new PostVO(9, 99,
                "new title",  "new content");

        String res = postService.createPost(p);

        return null;
    }

    @DeleteMapping("/posts/{id}")
    public String deletePostById(@PathVariable long id) {
        return postService.deletePost(id);
    }
}
