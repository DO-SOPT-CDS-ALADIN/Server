package com.example.DOSOPTaladin.util.error;

public class BadRequestException extends RuntimeException{
    public BadRequestException(ErrorResponseStatus status){
        super(status.getMessage());
    }
}