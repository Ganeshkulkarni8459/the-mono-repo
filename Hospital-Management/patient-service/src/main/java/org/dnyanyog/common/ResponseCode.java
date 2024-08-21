package org.dnyanyog.common;

public enum ResponseCode {
  ADD_PATIENT_SUCCESS("Success", "Patient Add Sucessfully"),
  ADD_PATIENT_FAIL("Fail", "Mobile Number Is Already present"),
  SEARCH_PATIENT_SUCCESS("Success", "Patient found Sucessfully "),
  SEARCH_PATIENT_FAIL("Fail", "Patient not found"),
  UPDATE_PATIENT_SUCCESS("Success", "Patient updated Successfully"),
  UPDATE_PATIENT_FAIL("Fail", "Patient not found"),
  DELETE_PATIENT_SUCCESS("Success", "Patient Deleted Successfully"),
  DELETE_PATIENT_FAIL("Fail", "Patient not found");

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
