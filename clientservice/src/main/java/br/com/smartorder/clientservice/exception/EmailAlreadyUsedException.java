package br.com.smartorder.clientservice.exception;

public class EmailAlreadyUsedException extends Exception {

    public EmailAlreadyUsedException() {
        super("Email is Already Used");
    }
}
