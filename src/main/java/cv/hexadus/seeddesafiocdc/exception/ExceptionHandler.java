package cv.hexadus.seeddesafiocdc.exception;

import cv.hexadus.seeddesafiocdc.util.APIResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Object> details = ex.getBindingResult().getAllErrors().stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        APIResponse error = APIResponse.Builder.newBuilder()
                .status(false)
                .statusText(HttpStatus.BAD_REQUEST.name())
                .details(details)
                .build();
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }
}
