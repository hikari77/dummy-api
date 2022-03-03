package com.bosco.dummyrest.controllers;

import com.bosco.dummyrest.entities.ArticleEntity;
import com.bosco.dummyrest.services.ArticleService;
import com.bosco.dummyrest.vo.ArticleVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles/{id}")
    public ArticleVO getPost(@PathVariable int id) {
        ArticleVO post = articleService.getPostById(id);

        return post;
    }

    @GetMapping("/articles")
    public ResponseEntity<?> getAllPosts() throws JsonProcessingException {
        List<ArticleVO> posts = articleService.getAllPosts();

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/articles")
    public ArticleVO createPost() {
        ArticleVO p = new ArticleVO(9L, 99L,
                "new title",  "new content");

        String res = articleService.createPost(p);

        return null;
    }

    @DeleteMapping("/articles/{id}")
    public String deletePostById(@PathVariable long id) {
        return articleService.deletePost(id);
    }
}
