package org.dnyanyog.common;

public enum ResponseCode {
  ADD_CASE_SUCCESS("Success", "Case Add Sucessfully"),
  SEARCH_CASE_SUCCESS("Success", "Case found Sucessfully "),
  SEARCH_CASE_FAIL("Fail", "Case not found"),
  UPDATE_CASE_SUCCESS("Success", "Case updated Successfully"),
  UPDATE_CASE_FAIL("Fail", "Case not found"),
  DELETE_CASE_SUCCESS("Success", "Case Deleted Successfully"),
  DELETE_CASE_FAIL("Fail", "Case not found");

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
