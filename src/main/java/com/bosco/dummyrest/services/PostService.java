package com.bosco.dummyrest.services;

import com.bosco.dummyrest.dao.PostRepository;
import com.bosco.dummyrest.entities.PostEntity;
import com.bosco.dummyrest.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostInitService postInitService;

    public List<PostEntity> getAllPosts() {
        // no db for now
//        List<PostEntity> posts = postRepository.findAll();
        List<PostEntity> posts = new ArrayList<>();

        // TODO exception handle
        if (posts.size() == 0) {
            posts = postInitService.retrievePostsFromFreeAPI();
        }
        System.out.println("size is: ------  " + posts.size());
        return posts;
    }

    public String createPost(PostVO post) {

        return null;
    }

    public PostVO getPostById(long id) {

        return null;
    }



    public String deletePost(long id) {
        return "" + id;
    }
}
