package com.bosco.dummyrest.controllers;

import com.bosco.dummyrest.entities.ArticleEntity;
import com.bosco.dummyrest.exceptions.ArticleNotFoundException;
import com.bosco.dummyrest.services.ArticleService;
import com.bosco.dummyrest.vo.ArticleVO;
import com.bosco.dummyrest.vo.ErrorResponse;
import com.bosco.dummyrest.vo.ResponseMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {
    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<?> getArticle(@PathVariable int id) {
        ArticleVO article = articleService.getArticleById(id);

        if (article == null) {
            throw new ArticleNotFoundException("Article not found.");
        }
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @GetMapping("/articles")
    public ResponseEntity<?> getAllArticles() {
        List<ArticleVO> articles = articleService.getAllArticles();
        // articles = null;
        if (articles == null) {
            throw new ArticleNotFoundException("Articles not found.");
        }
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<ResponseMessage> createArticle(@RequestBody ArticleVO articleVO ) {
        ArticleVO savedArticle = articleService.createArticle(articleVO);

        return new ResponseEntity<ResponseMessage>(new ResponseMessage("user created", savedArticle), HttpStatus.CREATED);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<ResponseMessage> deleteArticleById(@PathVariable long id) {
        ArticleVO articleVO = articleService.getArticleById(id);
        if (articleVO == null) {
            throw new ArticleNotFoundException("Article not found.");
        }
        articleService.deleteArticle(id);
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Article deleted."), HttpStatus.OK);
    }

    @ExceptionHandler(ArticleNotFoundException.class)
    public  ResponseEntity<ErrorResponse> articleNotFoundExceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getMessage());
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        logger.error(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
