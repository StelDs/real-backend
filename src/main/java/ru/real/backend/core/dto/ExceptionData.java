package ru.real.backend.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ExceptionData extends Exception {
    private final String id;
    private final String title;
    private final String detail;
    private final String request;
    private final String code;
    private final String time;
    private String exception;
    private String trace;

    @JsonCreator
    public ExceptionData(@JsonProperty("title") String title,
                         @JsonProperty("detail") String detail,
                         @JsonProperty("errorCode") String code,
                         @JsonProperty("request") String request,
                         @JsonProperty("time") String time,
                         @JsonProperty("errorTraceId") String id) {
        this.title = title;
        this.detail = detail;
        this.code = code;
        this.request = request;
        this.time = time;
        this.id = id;
    }

    @JsonCreator
    public ExceptionData(@JsonProperty("title") String title,
                         @JsonProperty("detail") String detail,
                         @JsonProperty("errorCode") String code,
                         @JsonProperty("request") String request,
                         @JsonProperty("time") String time,
                         @JsonProperty("errorTraceId") String id,
                         @JsonProperty("exception") String exception,
                         @JsonProperty("stackTrace") String trace) {
        this.title = title;
        this.detail = detail;
        this.code = code;
        this.request = request;
        this.time = time;
        this.id = id;
        this.exception = exception;
        this.trace = trace;
    }
}