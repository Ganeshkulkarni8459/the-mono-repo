package org.dnyanyog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class AddCaseRequest {

  @NotBlank(message = "Patient name cannot be blank")
  @Size(max = 100, message = "Patient name cannot exceed 100 characters")
  private String patientName;

  @NotBlank(message = "patientId cannot be blank")
  private String patientId;

  @NotNull(message = "Case number cannot be null")
  private String caseNumber;

  @NotNull(message = "Examination date cannot be null")
  private LocalDate examinationDate;

  @NotBlank(message = "Symptoms cannot be blank")
  private String symptoms;

  @NotBlank(message = "Prescription cannot be blank")
  public String prescription;

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
    return examinationDate;
  }

  public void setExaminationDate(LocalDate examinationDate) {
    this.examinationDate = examinationDate;
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
