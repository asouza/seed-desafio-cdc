package br.com.rsfot.bookstore.error.handler;

public class EmailDuplicatedException extends RuntimeException {
    public EmailDuplicatedException(String email) {
        super("Email %s already exists! Please, use another one.".formatted(email));
    }
}
