package hello.springmvc.basic.config.error.exception;

import hello.springmvc.basic.config.error.ErrorCode;

public class BadRequestException extends CustomBaseException {

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode.getMessage(), errorCode);
    }

    public BadRequestException() {
        super(ErrorCode.NOT_FOUND);
    }
}