package org.dnyanyog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class AddPatientResponse {

  public String status;

  public String message;

  public String patientNameInEnglish;

  public String patientNameInMarathi;

  public long mobileNumber;

  public String gender;

  public LocalDate birthDate;

  public LocalDate firstExaminationDate;

  public String address;

  public String patientId;

  public String getPatientNameInEnglish() {
    return patientNameInEnglish;
  }

  public void setPatientNameInEnglish(String patientNameInEnglish) {
    this.patientNameInEnglish = patientNameInEnglish;
  }

  public String getPatientNameInMarathi() {
    return patientNameInMarathi;
  }

  public void setPatientNameInMarathi(String patientNameInMarathi) {
    this.patientNameInMarathi = patientNameInMarathi;
  }

  public long getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(long mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public LocalDate getFirstExaminationDate() {
    return firstExaminationDate;
  }

  public void setFirstExaminationDate(LocalDate firstExaminationDate) {
    this.firstExaminationDate = firstExaminationDate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
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
}
