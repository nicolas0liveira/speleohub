package com.aftermidnight.speleohub.core.exceptionhandler;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.lang.NonNull;

import lombok.Builder;

public class Problem extends ProblemDetail {

    @Builder
    public Problem(String title, String detail, ProblemType problemType, @NonNull HttpStatus status, Exception exception,
            OffsetDateTime timestamp, String userMessage) {
            
        String titlee = title !=null?title:problemType.getTitle();
        this.setTitle(titlee);
        this.setDetail(detail);
        this.setStatus(status);
        this.setType(problemType.getType());
        this.setProperty("StackTrace", exception.getStackTrace());
        this.setProperty("Categoria", problemType.getCategory());
        this.setProperty("TimeStamp", timestamp);
        this.setProperty("UserMessage", userMessage);

    }

}