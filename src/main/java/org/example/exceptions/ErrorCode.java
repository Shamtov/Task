package org.example.exceptions;

public enum ErrorCode {
    ENTITY_ALREADY_EXIST_ERROR("Запись уже существует"),
    BAD_REQUEST_ERROR("Некорректный запрос"),
    NOT_FOUND("Данные по запросу не найдены");

    final String reason;

    ErrorCode(String reason) {
        this.reason = reason;
    }
}