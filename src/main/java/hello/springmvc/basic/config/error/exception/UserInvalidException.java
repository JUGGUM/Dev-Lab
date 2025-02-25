package hello.springmvc.basic.config.error.exception;

import hello.springmvc.basic.config.error.ErrorCode;

public class UserInvalidException extends BadRequestException {

    public UserInvalidException(String invalidUser) {
        super(ErrorCode.USER_INVALID);
    }
}
