package br.com.smartorder.clientservice.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User Not Found");
    }
}
