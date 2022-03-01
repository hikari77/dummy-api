package com.bosco.dummyrest.services;

import com.bosco.dummyrest.entities.PostEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostInitService {

    // TODO
    private ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(PostInitService.class);

    private final RestTemplate restClient;

    public PostInitService(@Qualifier("restClient") RestTemplate restClient) {
        this.restClient = restClient;
    }

    public List<PostEntity> retrievePostsFromFreeAPI() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<String> res = restClient.getForEntity(url, String.class);
        List<PostEntity> posts = null;

        try {
            posts = mapper.readValue(res.getBody(), List.class);
        } catch (JsonProcessingException e) {
            logger.error("Failed to get posts from free api site.");
        }
        return posts;
    }
}
