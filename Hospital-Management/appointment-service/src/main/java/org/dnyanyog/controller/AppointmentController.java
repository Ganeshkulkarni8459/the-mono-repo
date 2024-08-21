package org.dnyanyog.controller;

import jakarta.validation.Valid;
import org.dnyanyog.dto.AddAppointmentRequest;
import org.dnyanyog.dto.AddAppointmentResponse;
import org.dnyanyog.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

  @Autowired AppointmentService service;

  @PostMapping(
      path = "/api/v1/appointment/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public AddAppointmentResponse addPatient(@Valid @RequestBody AddAppointmentRequest request) {
    return service.addAppointment(request);
  }

  @GetMapping(path = "/api/v1/appointment/search/appointmentId/{appointmentId}")
  public AddAppointmentResponse searchCase(@PathVariable String appointmentId) {
    return service.searchAppointment(appointmentId);
  }

  @GetMapping(path = "/api/v1/appointment/search/patientId/{patientId}")
  public AddAppointmentResponse searchPatientUsingPatientId(@PathVariable String patientId) {
    return service.searchAppointmentUsingPatientId(patientId);
  }

  @PostMapping(
      path = "/api/v1/appointment/edit/{appointmentId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public AddAppointmentResponse updateCase(
      @PathVariable String appointmentId, @RequestBody AddAppointmentRequest request) {
    return service.updateAppointment(appointmentId, request);
  }

  @DeleteMapping(
      path = "/api/v1/appointment/delete/{appointmentId}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public AddAppointmentResponse deleteCase(@PathVariable String appointmentId) {
    return service.deleteAppointment(appointmentId);
  }
}
