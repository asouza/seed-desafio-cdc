package com.tiozao.cdd.loja.controller.api

import jakarta.validation.ConstraintViolationException
import org.hibernate.validator.internal.engine.path.PathImpl
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
internal class ErrorHandlingControllerAdvice {
    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun onConstraintValidationException(
        e: ConstraintViolationException
    ): ValidationErrorResponse {
        val error = ValidationErrorResponse()
        for (violation in e.getConstraintViolations()) {
            error.getViolations().add(
                Violation(violation.propertyPath.last().name, violation.message)
            )
        }
        return error
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun onMethodArgumentNotValidException(
        e: MethodArgumentNotValidException
    ): ValidationErrorResponse {
        val error = ValidationErrorResponse()
        for (fieldError in e.bindingResult.fieldErrors) {
            error.getViolations().add(
                Violation(fieldError.field, fieldError.defaultMessage)
            )
        }
        return error
    }


}

class ValidationErrorResponse {
    private var errorList : MutableList<Violation> = mutableListOf()
    fun getViolations(): MutableList<Violation>  {
        return this.errorList
    }
}

data class Violation(
    var fieldName: String,
    var message: String?
)
