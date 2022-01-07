package com.demo.insuranceproductsstore.reviewservice.exception;

import com.demo.insuranceproductsstore.reviewservice.model.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    private String ACCESSES_DENIED = "ACCESSES_DENIED";

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> userNotFoundExceptionHandler(RecordNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(ex.getLocalizedMessage(), INCORRECT_REQUEST), HttpStatus.OK);
    }

    @ExceptionHandler(CommentAccessDeniedException.class)
    public final ResponseEntity<ErrorResponse> userAccessesDeniedTApprovalCommentExceptionHandler(CommentAccessDeniedException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(ex.getLocalizedMessage(), ACCESSES_DENIED), HttpStatus.OK);
    }

    @ExceptionHandler(RegisterCommentException.class)
    public final ResponseEntity<ErrorResponse> registerCommentExceptionHandler(RegisterCommentException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(ex.getLocalizedMessage(), ACCESSES_DENIED), HttpStatus.OK);
    }
}
