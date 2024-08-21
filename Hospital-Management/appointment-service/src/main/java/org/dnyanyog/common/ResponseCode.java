package org.dnyanyog.common;

public enum ResponseCode {
  ADD_APPOINTMENT_SUCCESS("Success", "Appointment Add Sucessfully"),
  SEARCH_APPOINTMENT_SUCCESS("Success", "Appointment found Sucessfully "),
  SEARCH_APPOINTMENT_FAIL("Fail", "Appointment not found"),
  UPDATE_APPOINTMENT_SUCCESS("Success", "Appointment updated Successfully"),
  UPDATE_APPOINTMENT_FAIL("Fail", "Appointment not found"),
  DELETE_APPOINTMENT_SUCCESS("Success", "Appointment Deleted Successfully"),
  DELETE_APPOINTMENT_FAIL("Fail", "Appointment not found");

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
