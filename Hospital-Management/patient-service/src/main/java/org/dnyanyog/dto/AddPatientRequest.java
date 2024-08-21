package org.dnyanyog.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class AddPatientRequest {

  @NotBlank(message = "Patient name in English is required")
  private String patientNameInEnglish;

  @NotBlank(message = "Patient name in Marathi is required")
  private String patientNameInMarathi;

  @Digits(integer = 10, fraction = 0, message = "Mobile number should be a 10 digit number")
  private long mobileNumber;

  @NotBlank(message = "Gender is required")
  @Pattern(regexp = "Male|Female|Other", message = "Gender must be either Male, Female, or Other")
  private String gender;

  @NotNull(message = "Birth date is required")
  @PastOrPresent(message = "Birth date cannot be in the future")
  private LocalDate birthDate;

  @NotNull(message = "First examination date is required")
  private LocalDate firstExaminationDate;

  @NotBlank(message = "Address is required")
  private String address;

  public String patientId;

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

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
}
