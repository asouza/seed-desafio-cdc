package br.com.kleberson2santos.casadocodigov1.novoautor;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsOutputDto {

    private List<String> globalErrorMessages = new ArrayList<>();

    private List<FieldErrorOutputDto> fieldErros = new ArrayList<>();

    public void addError(String message) {
        globalErrorMessages.add(message);
    }

    public void addFieldError(String field, String message){
        FieldErrorOutputDto fieldError =  new FieldErrorOutputDto(field, message);
        fieldErros.add(fieldError);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<FieldErrorOutputDto> getErros() {
        return fieldErros;
    }

    public int getNumberOfErrors(){
        return fieldErros.size();
    }
}
