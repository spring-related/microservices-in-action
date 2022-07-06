package com.optimagrowth.license.model.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    private String message;
    private String code;
    private String detail;

    public ErrorMessage(String message, String code, String detail) {
        super();
        this.message = message;
        this.code = code;
        this.detail = detail;
    }

    public ErrorMessage(String message, String detail) {
        super();
        this.message = message;
        this.detail = detail;
    }

    public ErrorMessage(String message) {
        this(message, "", "");
    }
}
