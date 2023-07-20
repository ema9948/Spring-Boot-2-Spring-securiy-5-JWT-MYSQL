package com.cristianAlbornoz.ShopRopa.Utils.ExceptionsResponse;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseExGen extends RuntimeException {
    private final String code;

    public ResponseExGen(String code, HttpStatus status, String message) {
        super(message);
        this.code = code;
    }
}
