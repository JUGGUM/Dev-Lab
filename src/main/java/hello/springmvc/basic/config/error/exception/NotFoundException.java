package hello.springmvc.basic.config.error.exception;

import hello.springmvc.basic.config.error.ErrorCode;

public class NotFoundException extends CustomBaseException {

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage(), errorCode);
    }

    public NotFoundException() {
        super(ErrorCode.NOT_FOUND);
    }
}