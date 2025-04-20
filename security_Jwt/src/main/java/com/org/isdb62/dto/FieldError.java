package com.org.isdb62.dto;

public record FieldError(
        String field,
        String errorCode,
        String errorMessage
) {
}
