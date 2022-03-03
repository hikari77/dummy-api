package com.bosco.dummyrest.services;

import com.bosco.dummyrest.dao.ArticleRepository;
import com.bosco.dummyrest.entities.ArticleEntity;
import com.bosco.dummyrest.util.ArticleEntityConverter;
import com.bosco.dummyrest.vo.ArticleVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleInitService articleInitService;

    public List<ArticleVO> getAllPosts() {
        List<ArticleEntity> articles = articleRepository.findAll();

        // TODO exception handle
        if (articles.size() == 0) {

            List<ArticleVO> articleVOList =  articleInitService.retrievePostsFromFreeAPI();

            articles = ArticleEntityConverter.convertVosToEntityList(articleVOList);

            // save to db
            articleRepository.saveAll(articles);

            return articleVOList;
        }

        return ArticleEntityConverter.convertEntityListToVOList(articles);
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
