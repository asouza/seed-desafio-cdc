package org.ecorp.casadocodigo.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException() {
    super("Resource not found!");
  }

  public ResourceNotFoundException(String resourceName, Long resourceIdentifier) {
    super("Resource " + resourceName + " with identifier " + resourceIdentifier + " not found!");
  }
}
