package org.example.exceptions;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtil {
    public static final String AUTH_ERROR = "401 Unauthorized";
    public static final String ACCESS_DENIED = "403 Forbidden";
    public static final String INVALID_AUTH_DATA = "Ошибка аутентификации";
    public static final String NOT_ENOUGH_RIGHTS = "Недостаточно прав для выполнения операции";
    public static final String BAD_REQUEST = "400 Bad Request";
    public static final String NOT_FOUND = "404 Not Found";
    public static final String INTERNAL_SERVER_ERROR = "Внутренняя ошибка сервера";
    public static final String UNAVAILABLE_SERVER_ERROR = "Сервис недоступен";
    public static final String TASK_NOT_FOUND = "Задача не найдена";
    public static final String ERROR_FOR_LOG = "Error. ";
}
