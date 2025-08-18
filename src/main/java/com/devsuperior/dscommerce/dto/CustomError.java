package com.devsuperior.dscommerce.dto;

import java.time.Instant;

public class CustomError {

    private Instant timestamp;
    private Integer status;
    private String message;
    private String path;



    public CustomError(Instant timestamp,int status, String message,String path) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.status = status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }



    public String getPath() {
        return path;
    }

    public int getStatus() {
        return status;
    }
}
