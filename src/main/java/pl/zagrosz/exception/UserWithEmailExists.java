package pl.zagrosz.exception;


public class UserWithEmailExists extends RuntimeException {

  public UserWithEmailExists(String message) {
    super(message);
  }
}
