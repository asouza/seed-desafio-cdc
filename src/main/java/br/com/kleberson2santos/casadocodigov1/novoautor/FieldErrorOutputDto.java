package br.com.kleberson2santos.casadocodigov1.novoautor;

public class FieldErrorOutputDto {

    private final String field;
    private final String message;

    public FieldErrorOutputDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
