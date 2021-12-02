package com.gg.manager.controller;

import com.gg.manager.response.Result;
import com.gg.manager.response.ResultConstant;

public abstract class AbstractController {
    private static final String SUCCESSFUL_MESSAGE = "OK";

    protected Result<Void> successResponse() {
        return new Result<>(ResultConstant.STATUS_OK, SUCCESSFUL_MESSAGE);
    }

    protected <T> Result<T> successResponse(T data) {
        return new Result<T>(ResultConstant.STATUS_OK, SUCCESSFUL_MESSAGE, data);
    }

    protected <T> Result<T> successResponse(String message, T data) {
        return new Result<T>(ResultConstant.STATUS_OK, message, data);
    }
}
