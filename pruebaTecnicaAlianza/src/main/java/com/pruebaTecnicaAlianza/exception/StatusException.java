package com.pruebaTecnicaAlianza.exception;

import lombok.Data;

@Data
public class StatusException extends RuntimeException {

    private String status;
    private String message;

    public StatusException() {

    }

    public StatusException(String status,Throwable cause) {
        super("Status: "+ status+ " message: "+ cause);
        this.status = status;
        this.message = message;

    }
}
