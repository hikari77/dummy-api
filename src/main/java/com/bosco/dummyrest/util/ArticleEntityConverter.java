package com.bosco.dummyrest.util;

import com.bosco.dummyrest.entities.ArticleEntity;
import com.bosco.dummyrest.vo.ArticleVO;

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
}
