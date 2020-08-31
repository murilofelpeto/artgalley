package br.com.murilo.artgalley.exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private final LocalDateTime date;
    private final String message;
    private final String details;

    public ExceptionResponse(final LocalDateTime date, final String message, final String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
