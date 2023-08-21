package author.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthorRequestExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handlerMethodArgumentNotValid(final MethodArgumentNotValidException ex) {
		List<String> details = ex.getAllErrors().stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.toList());
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}

}
