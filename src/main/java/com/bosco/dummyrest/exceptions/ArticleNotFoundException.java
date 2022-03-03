package com.bosco.dummyrest.exceptions;

public class ArticleNotFoundException extends ArticleException {
    public ArticleNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
