package org.dnyanyog.common;

public enum ResponseCode {
  ADD_USER_SUCCESS("Success", "User Add Sucessfully"),
  ADD_USER_FAIL("Fail", "Mobile Number Already Exit"),
  SEARCH_USER_SUCCESS("Success", "User found Sucessfully "),
  SEARCH_USER_FAIL("Fail", "User not found"),
  UPDATE_USER_SUCCESS("Success", "User updated Successfully"),
  UPDATE_USER_FAIL("Fail", "User not found"),
  DELETE_USER_SUCCESS("Success", "User Deleted Successfully"),
  DELETE_USER_FAIL("Fail", "User not found"),

  LOGIN_USER_SUCCESS("Success", "Login Successfully"),
  MOBILE_NUMBER_NOT_PRESENT("Fail", "Mobile Number Does Not Exit"),
  MOBILE_NUMBER_AND_PASSWORD_DOES_NOT_MATCH("Fail", "Mobile Number And Password Does Not Match");

  private final String status;
  private final String message;

  ResponseCode(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
