package cryss.dev.author_api.infrastructure.configuration.exception;

import cryss.dev.author_api.infrastructure.configuration.utils.Constants;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    public static final String CONSTRAINT_VALIDATION_FAILED = "Constraint validation failed";

    /**
     *
     * @param exMethod
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validationError(MethodArgumentNotValidException exMethod) {

        BindingResult bindingResult = exMethod.getBindingResult();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<String> fieldErrorDtos = fieldErrors.stream()
                .map(f -> f.getField().concat(":").concat(f.getDefaultMessage())).map(String::new)
                .toList();

        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .origin(Constants.ORIGIN_AUTHOR_API)
                .description(fieldErrorDtos.toString())
                .build();

        return ResponseEntity.status(ex.getHttpStatusCode()).body(ex.getOnlyBody());
    }

    /**
     *
     * @param exMethod
     * @param request
     * @return
     */
    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(DataIntegrityViolationException exMethod, WebRequest request) {

        String error = exMethod.getMessage ().contains ("email") ? "E-mail informado já utilizado." : exMethod.getMessage ();

        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.UNPROCESSABLE_ENTITY)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(Arrays.asList(error).toString())
                .build();

        return ResponseEntity.status(ex.getHttpStatusCode()).body(ex.getOnlyBody());
    }

}
