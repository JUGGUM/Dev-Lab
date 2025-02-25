package hello.springmvc.basic.config.error.exception;

import hello.springmvc.basic.config.error.ErrorCode;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
