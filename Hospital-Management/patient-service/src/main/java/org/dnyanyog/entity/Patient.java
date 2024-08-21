package org.dnyanyog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Patient {

  @Id
  @Column(name = "patient_id", unique = true, nullable = false)
  private String patientId;

  @Column(name = "patient_name_in_english", nullable = false)
  private String patientNameInEnglish;

  @Column(name = "patient_name_in_marathi", nullable = false)
  private String patientNameInMarathi;

  @Column(name = "mobile_number", nullable = false)
  private long mobileNumber;

  @Column(name = "gender", nullable = false)
  private String gender;

  @Column(name = "birth_date", nullable = false)
  private LocalDate birthDate;

  @Column(name = "first_examination_date", nullable = false)
  private LocalDate firstExaminationDate;

  @Column(name = "address", nullable = false)
  private String address;

  public static Patient getInstance() {
    return new Patient();
  }

  public String getPatientId() {
    return patientId;
  }

  public Patient setPatientId(String patientId) {
    this.patientId = patientId;
    return this;
  }

  public String getPatientNameInEnglish() {
    return patientNameInEnglish;
  }

  public Patient setPatientNameInEnglish(String patientNameInEnglish) {
    this.patientNameInEnglish = patientNameInEnglish;
    return this;
  }

  public String getPatientNameInMarathi() {
    return patientNameInMarathi;
  }

  public Patient setPatientNameInMarathi(String patientNameInMarathi) {
    this.patientNameInMarathi = patientNameInMarathi;
    return this;
  }

  public long getMobileNumber() {
    return mobileNumber;
  }

  public Patient setMobileNumber(long mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public Patient setGender(String gender) {
    this.gender = gender;
    return this;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public Patient setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  public LocalDate getFirstExaminationDate() {
    return firstExaminationDate;
  }

  public Patient setFirstExaminationDate(LocalDate firstExaminationDate) {
    this.firstExaminationDate = firstExaminationDate;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Patient setAddress(String address) {
    this.address = address;
    return this;
  }
}
