package com.gg.manager.exception;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.gg.manager.response.Result;
import com.gg.manager.response.ResultConstant;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    public Result<String> runtimeException(RuntimeException e) {
        e.printStackTrace();
        return new Result<>(ResultConstant.STATUS_DEFAULT_ERROR, ResultConstant.DEFAULT_EXCEPTION);
    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public Result<String> allException(Exception e) {
        e.printStackTrace();
        return new Result<>(ResultConstant.STATUS_DEFAULT_ERROR, ResultConstant.DEFAULT_EXCEPTION);
    }

    /**
     * Handle token error exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler({SignatureVerificationException.class, AlgorithmMismatchException.class, JWTDecodeException.class})
    public Result<String> tokenErrorException() {
        return new Result<>(ResultConstant.STATUS_TOKEN_ERROR, ResultConstant.TOKEN_ERROR_EXCEPTION);
    }

    /**
     * Handle token time out exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler({TokenExpiredException.class})
    public Result<String> tokenExpiredException() {
        return new Result<>(ResultConstant.STATUS_TOKEN_EXPIRED, ResultConstant.TOKEN_EXPIRED_EXCEPTION);
    }

    /**
     * Handle token time out exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler({ValidationException.class})
    public Result<Set<String>> validationException(ValidationException e) {
        return new Result<>(ResultConstant.STATUS_VALIDATION_ERROR, ResultConstant.VALIDATION_EXCEPTION, e.getValidationMessageSet());
    }
}
