package com.mtj.formatterresponse.handler;

import com.mtj.formatterresponse.entityFormatter.ErrorFieldResponse;
import com.mtj.formatterresponse.entityFormatter.ErrorResponse;
import com.mtj.formatterresponse.entityFormatter.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {




    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> internalServerErrorException(Exception exception) {
        log.error(exception.getMessage());
        return createHttpResponse(INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HttpResponse> internalServerErrorException(RuntimeException exception) {
        log.error(exception.getMessage());
        return createHttpResponse(INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    protected ResponseEntity<HttpResponse> createHttpResponse(HttpStatus status, String message) {
        HttpResponse response = ErrorResponse.builder().reason(status.getReasonPhrase()).build();
        response.setStatus(status);
        response.setMessage(message);
        return new ResponseEntity<>(response, status);
    }

    protected ResponseEntity<HttpResponse> createValidationHttpResponse(String message, List<FieldError> errors) {
        List<ErrorFieldResponse> fieldResponses = errors.stream().map(fieldError -> {
            ErrorFieldResponse response = new ErrorFieldResponse();
            BeanUtils.copyProperties(fieldError, response);
            return response;
        }).collect(Collectors.toList());
        HttpResponse response = ErrorResponse.builder().reason(HttpStatus.BAD_REQUEST.getReasonPhrase()).validations(fieldResponses).build();
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setMessage(message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
