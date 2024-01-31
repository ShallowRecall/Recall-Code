package com.hspedu.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ZhouYu
 * @version 1.0
 */
@ResponseStatus(reason = "年龄需要在1-120之间", value = HttpStatus.BAD_REQUEST)
public class AgeException extends RuntimeException {

    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }
}
