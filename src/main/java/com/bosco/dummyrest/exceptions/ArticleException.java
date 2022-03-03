package com.bosco.dummyrest.exceptions;

public abstract class ArticleException extends RuntimeException {
    private String errorMessage;

    public String getErrorMessage() { return errorMessage; }

    public ArticleException() {
        super();
    }

    public ArticleException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
