package com.bosco.dummyrest;

import com.bosco.vo.Employee;
import com.bosco.vo.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    private MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable int id) {
        Post post = myService.getPostById(id);

        return post;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() throws JsonProcessingException {
        List<Post> posts = myService.getAllPosts();

        return posts;
    }

    @PostMapping("/posts")
    public Post createPost() {
        // hard coded post object
        Post p = new Post(9, 99,
               "new title",  "new content");

        Post res = myService.createPost(p);

        return res;
    }

    @DeleteMapping("/posts/{id}")
    public String deletePostById(@PathVariable int id) {
        return myService.deletePost(id);
    }
}
