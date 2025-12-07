package com.els.supabasemanager.controllers.Errors;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

}
