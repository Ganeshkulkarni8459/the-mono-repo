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
public class Appointment {

  @Id
  @Column(name = "appointment_Id", unique = true, nullable = false)
  private String appointmentId;

  @Column(name = "patient_name", nullable = false)
  private String patientName;

  @Column(name = "patient_id", nullable = false)
  private String patientId;

  @Column(name = "examination_date", nullable = false)
  private LocalDate examinationDate;

  @Column(name = "appointment_Time", nullable = false)
  private String appointmentTime;

  public static Appointment getInstance() {
    return new Appointment();
  }

  public String getAppointmentId() {
    return appointmentId;
  }

  public Appointment setAppointmentId(String appointmentId) {
    this.appointmentId = appointmentId;
    return this;
  }

  public String getPatientName() {
    return patientName;
  }

  public Appointment setPatientName(String patientName) {
    this.patientName = patientName;
    return this;
  }

  public String getPatientId() {
    return patientId;
  }

  public Appointment setPatientId(String patientId) {
    this.patientId = patientId;
    return this;
  }

  public LocalDate getExaminationDate() {
    return examinationDate;
  }

  public Appointment setExaminationDate(LocalDate examinationDate) {
    this.examinationDate = examinationDate;
    return this;
  }

  public String getAppointmentTime() {
    return appointmentTime;
  }

  public Appointment setAppointmentTime(String appointmentTime) {
    this.appointmentTime = appointmentTime;
    return this;
  }
}
