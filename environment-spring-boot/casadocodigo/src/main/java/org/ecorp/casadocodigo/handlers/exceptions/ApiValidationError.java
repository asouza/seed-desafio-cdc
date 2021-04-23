package org.ecorp.casadocodigo.handlers.exceptions;

public class ApiValidationError extends ApiSubError {

  private String object;
  private String field;
  private Object rejectedValue;
  private String message;

  public ApiValidationError(String object, String field, Object rejectedValue, String message) {
    this.object = object;
    this.field = field;
    this.rejectedValue = rejectedValue;
    this.message = message;
  }

  ApiValidationError(String object, String message) {
    this.object = object;
    this.message = message;
  }

  @Override
  public String toString() {
    return String.format("ApiValidationError [object=%s, field=%s, rejectedValue=%s, message=%s]",
        object, field, rejectedValue, message);
  }

  /**
   * @return the object
   */
  public String getObject() {
    return object;
  }

  /**
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * @return the rejectedValue
   */
  public Object getRejectedValue() {
    return rejectedValue;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }



}
