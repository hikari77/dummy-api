package com.bosco.dummyrest.controllers;

import com.bosco.dummyrest.entities.ArticleEntity;
import com.bosco.dummyrest.services.ArticleService;
import com.bosco.dummyrest.vo.ArticleVO;
import com.bosco.dummyrest.vo.ResponseMessage;
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
    public ResponseEntity<?> getPost(@PathVariable int id) {
        ArticleVO article = articleService.getArticleById(id);

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @GetMapping("/articles")
    public ResponseEntity<?> getAllPosts() throws JsonProcessingException {
        List<ArticleVO> posts = articleService.getAllArticles();

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/articles")
    public ResponseEntity<ResponseMessage> createPost() {

        return null;
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<ResponseMessage> deletePostById(@PathVariable long id) {
        return null;
    }
}
