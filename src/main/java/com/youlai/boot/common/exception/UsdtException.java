package com.youlai.boot.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class UsdtException extends RuntimeException {

    public UsdtException() {}

    public UsdtException(String message) {
        super(message);
    }
}
