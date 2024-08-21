package org.dnyanyog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class AddCaseResponse {

  private String CaseId;

  private String status;

  private String message;

  private String patientName;

  private String patientId;

  private String caseNumber;

  private LocalDate ExaminationDate;

  private String symptoms;

  public String prescription;

  public static AddCaseResponse getInstance() {
    return new AddCaseResponse();
  }

  public String getCaseId() {
    return CaseId;
  }

  public void setCaseId(String caseId) {
    CaseId = caseId;
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

  public String getCaseNumber() {
    return caseNumber;
  }

  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
  }

  public LocalDate getExaminationDate() {
    return ExaminationDate;
  }

  public void setExaminationDate(LocalDate examinationDate) {
    ExaminationDate = examinationDate;
  }

  public String getSymptoms() {
    return symptoms;
  }

  public void setSymptoms(String symptoms) {
    this.symptoms = symptoms;
  }

  public String getPrescription() {
    return prescription;
  }

  public void setPrescription(String prescription) {
    this.prescription = prescription;
  }
}
