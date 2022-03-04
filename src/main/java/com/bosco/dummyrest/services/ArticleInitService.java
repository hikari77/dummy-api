package com.bosco.dummyrest.services;

import com.bosco.dummyrest.entities.ArticleEntity;
import com.bosco.dummyrest.vo.ArticleVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleInitService {


    private static final Logger logger = LoggerFactory.getLogger(ArticleInitService.class);

    private final RestTemplate restClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public ArticleInitService(@Qualifier("restClient") RestTemplate restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }

    public List<ArticleVO> retrievePostsFromFreeAPI() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<String> res = restClient.getForEntity(url, String.class);
        List<ArticleVO> articles = null;

        try {
            articles = objectMapper.readValue(res.getBody(), new TypeReference<List<ArticleVO>>() {});
        } catch (JsonProcessingException e) {
            logger.error("Failed to parse JSON.");
        }

        return articles;
    }
}
