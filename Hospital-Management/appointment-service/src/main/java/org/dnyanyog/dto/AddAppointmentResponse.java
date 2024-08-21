package org.dnyanyog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class AddAppointmentResponse {

  private String status;

  private String message;

  private String patientName;

  private String patientId;

  private LocalDate ExaminationDate;

  public String appointmentTime;

  public String appointmentId;

  public static AddAppointmentResponse getInstance() {
    return new AddAppointmentResponse();
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public String getAppointmentId() {
    return appointmentId;
  }

  public void setAppointmentId(String appointmentId) {
    this.appointmentId = appointmentId;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public LocalDate getExaminationDate() {
    return ExaminationDate;
  }

  public void setExaminationDate(LocalDate examinationDate) {
    ExaminationDate = examinationDate;
  }

  public String getAppointmentTime() {
    return appointmentTime;
  }

  public void setAppointmentTime(String appointmentTime) {
    this.appointmentTime = appointmentTime;
  }
}
