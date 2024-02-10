package br.com.rsfot.bookstore.error.handler;

public class EmailDuplicatedException extends RuntimeException {
    public EmailDuplicatedException() {
        super("Email already exists! Please, use another one.");
    }
}
