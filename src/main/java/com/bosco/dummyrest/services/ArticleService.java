package com.bosco.dummyrest.services;

import com.bosco.dummyrest.dao.ArticleRepository;
import com.bosco.dummyrest.entities.ArticleEntity;
import com.bosco.dummyrest.vo.ArticleVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleInitService articleInitService;

    public List<ArticleEntity> getAllPosts() {
        // no db for now
        List<ArticleEntity> articles = articleRepository.findAll();
//        List<PostEntity> posts = new ArrayList<>();

        // TODO exception handle
        if (articles.size() == 0) {
            articles = articleInitService.retrievePostsFromFreeAPI();
        }
        logger.info("size is: ------  " + articles.size());

//        logger.info(articles.toString());

        // save to db
//        articleRepository.saveAll(articles);

        return articles;
    }

    public String createPost(ArticleVO post) {

        return null;
    }

    public ArticleVO getPostById(long id) {

        return null;
    }



    public String deletePost(long id) {
        return "" + id;
    }
}
