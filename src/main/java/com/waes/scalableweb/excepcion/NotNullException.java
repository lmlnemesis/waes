package com.waes.scalableweb.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
public class NotNullException extends RuntimeException {

    public NotNullException() {
        super();
    }

    public NotNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotNullException(String message) {
        super(message);
    }

    public NotNullException(Throwable cause) {
        super(cause);
    }

}
