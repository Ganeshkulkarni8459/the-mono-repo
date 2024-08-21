package org.dnyanyog.service;

import org.dnyanyog.dto.AddAppointmentRequest;
import org.dnyanyog.dto.AddAppointmentResponse;

public interface AppointmentService {

  public AddAppointmentResponse addAppointment(AddAppointmentRequest request);

  public AddAppointmentResponse searchAppointment(String appointmentId);

  public AddAppointmentResponse searchAppointmentUsingPatientId(String patientId);

  public AddAppointmentResponse updateAppointment(
      String appointmentId, AddAppointmentRequest request);

  public AddAppointmentResponse deleteAppointment(String appointmentId);
}
