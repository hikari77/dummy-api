package com.bosco.dummyrest;

import com.bosco.vo.Employee;
import com.bosco.vo.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    private final String BASE = "https://jsonplaceholder.typicode.com";

    private RestTemplate rt = new RestTemplate();
    private ObjectMapper mapper = new ObjectMapper();

    public Post getPostById(int id) {
        String url = BASE + "/posts/" + id;

        Post post = rt.getForObject(url, Post.class);

        logger.info(String.valueOf(post));

        return post;
    }

    public List<Post> getAllPosts() throws JsonProcessingException {
        String url = BASE + "/posts";

        ResponseEntity<String> response = rt.getForEntity(url, String.class);

        List<Post> posts = mapper.readValue(response.getBody(), List.class);
        logger.info(posts.toString());

        return posts;
    }

    public Post createPost(Post post) {
        String url = BASE + "/posts";
        HttpEntity<Post> request = new HttpEntity<>(post);

        Post res = rt.postForObject(url, request, Post.class);
        logger.info(String.valueOf(res));

        return res;
    }

    public String deletePost(int id) {
        String url = BASE + "/posts" + id;
        // mock api will throw 404 error with delete request

        try {
            rt.delete(url, Post.class);
        } catch (Exception ex) {
            logger.error(ex.toString());
        }

        return "deleted post: " + id;
    }
}
