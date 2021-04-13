package com.nikki.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class ManyUsersException extends RuntimeException{
    public ManyUsersException(){

    }
    public ManyUsersException(String message){
        super(message);
    }
}
