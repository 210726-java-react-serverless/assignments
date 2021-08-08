package com.revature.Jamaal_Smith_P0.util.exceptions;

public class ScreenNotFoundException extends RuntimeException {
    public ScreenNotFoundException() {
        super("No screen found with provided route!");
    }
}
