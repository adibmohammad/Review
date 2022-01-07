package com.demo.insuranceproductsstore.reviewservice.exception;

public class CommentAccessDeniedException extends RuntimeException{
    public CommentAccessDeniedException() {
        super();
    }

    public CommentAccessDeniedException(String message) {
        super(message);
    }
}
