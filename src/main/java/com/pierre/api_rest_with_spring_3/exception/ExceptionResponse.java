package com.pierre.api_rest_with_spring_3.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
