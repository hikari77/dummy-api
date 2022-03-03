package com.bosco.dummyrest.util;

import com.bosco.dummyrest.entities.ArticleEntity;
import com.bosco.dummyrest.vo.ArticleVO;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleEntityConverter {
    public static ArticleVO convertEntityToArticleVO(ArticleEntity articleEntity) {
        if (articleEntity != null) {
            ArticleVO articleVO = new ArticleVO();
            articleVO.setUserId(articleEntity.getUserId());
            articleVO.setArticleId(articleEntity.getArticleId());
            articleVO.setContent(articleEntity.getContent());
            articleVO.setTitle(articleEntity.getTitle());
            return articleVO;
        }
        return null;
    }

    public static ArticleEntity convertVOToEntity(ArticleVO vo) {
        if (vo != null) {
            ArticleEntity e = new ArticleEntity();
            e.setContent(vo.getContent());
            e.setTitle(vo.getTitle());
            e.setUserId(vo.getUserId());
            e.setArticleId(vo.getArticleId());
            return e;
        }
        return null;
    }

    public static List<ArticleEntity> convertVosToEntityList (List<ArticleVO> vos) {
        return vos.stream()
                .map(e -> new ArticleEntity(e.getArticleId(), e.getUserId(), e.getTitle(), e.getContent()))
                .collect(Collectors.toList());
    }

    public static List<ArticleVO> convertEntityListToVOList(List<ArticleEntity> articles) {
        return articles.stream()
                .map(ArticleEntityConverter::convertEntityToArticleVO)
                .collect(Collectors.toList());
    }
}
