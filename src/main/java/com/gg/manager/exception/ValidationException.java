package com.gg.manager.exception;

import lombok.Data;

import java.util.Set;

@Data
public class ValidationException extends Exception {
    private static final long serialVersionUID = -5335593368897795884L;

    private Set<String> validationMessageSet;

    public ValidationException(String validationMessage) {
        super(validationMessage);
    }

    public ValidationException(Set<String> validationMessageSet) {
        this.validationMessageSet = validationMessageSet;
    }
}
