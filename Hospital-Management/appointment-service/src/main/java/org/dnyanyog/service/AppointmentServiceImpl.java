package org.dnyanyog.service;

import java.util.Optional;
import java.util.Random;
import org.dnyanyog.common.ResponseCode;
import org.dnyanyog.dto.AddAppointmentRequest;
import org.dnyanyog.dto.AddAppointmentResponse;
import org.dnyanyog.entity.Appointment;
import org.dnyanyog.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class AppointmentServiceImpl implements AppointmentService {

  @Autowired AppointmentRepository repo;

  public AddAppointmentResponse addAppointment(AddAppointmentRequest request) {
    AddAppointmentResponse response = AddAppointmentResponse.getInstance();

    Appointment requestData =
        Appointment.getInstance()
            .setPatientName(request.getPatientName())
            .setPatientId(request.getPatientId())
            .setExaminationDate(request.getExaminationDate())
            .setAppointmentTime(request.getAppointmentTime())
            .setAppointmentId(request.getAppointmentId());

    try {
      requestData = repo.save(requestData);
      response.setStatus(ResponseCode.ADD_APPOINTMENT_SUCCESS.getStatus());
      response.setMessage(ResponseCode.ADD_APPOINTMENT_SUCCESS.getMessage());
      response.setAppointmentId(requestData.getAppointmentId());

    } catch (Exception e) {
      e.printStackTrace();
    }

    return response;
  }

  public AddAppointmentResponse searchAppointment(String appointmentId) {

    AddAppointmentResponse response = AddAppointmentResponse.getInstance();

    Optional<Appointment> id = repo.findByAppointmentId(appointmentId);

    if (id.isPresent()) {

      Appointment receivedData = id.get();

      response.setPatientName(receivedData.getPatientName());
      response.setPatientId(receivedData.getPatientId());
      response.setExaminationDate(receivedData.getExaminationDate());
      response.setAppointmentTime(receivedData.getAppointmentTime());
      response.setAppointmentId(receivedData.getAppointmentId());

      response.setStatus(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getStatus());
      response.setMessage(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getMessage());
    } else {

      response.setStatus(ResponseCode.SEARCH_APPOINTMENT_FAIL.getStatus());
      response.setMessage(ResponseCode.SEARCH_APPOINTMENT_FAIL.getMessage());
    }

    return response;
  }

  public AddAppointmentResponse searchAppointmentUsingPatientId(String patientId) {
    AddAppointmentResponse response = AddAppointmentResponse.getInstance();

    Optional<Appointment> id = repo.findByPatientId(patientId);

    if (id.isPresent()) {

      Appointment receivedData = id.get();

      response.setPatientName(receivedData.getPatientName());
      response.setPatientId(receivedData.getPatientId());
      response.setExaminationDate(receivedData.getExaminationDate());
      response.setAppointmentTime(receivedData.getAppointmentTime());
      response.setAppointmentId(receivedData.getAppointmentId());

      response.setStatus(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getStatus());
      response.setMessage(ResponseCode.SEARCH_APPOINTMENT_SUCCESS.getMessage());
    } else {

      response.setStatus(ResponseCode.SEARCH_APPOINTMENT_FAIL.getStatus());
      response.setMessage(ResponseCode.SEARCH_APPOINTMENT_FAIL.getMessage());
    }

    return response;
  }

  public AddAppointmentResponse updateAppointment(
      String appointmentId, AddAppointmentRequest request) {

    AddAppointmentResponse response = AddAppointmentResponse.getInstance();

    Optional<Appointment> id = repo.findByAppointmentId(appointmentId);

    if (id.isPresent()) {
      Appointment tableData = id.get();

      tableData.setPatientName(request.getPatientName());
      tableData.setPatientId(request.getPatientId());
      tableData.setExaminationDate(request.getExaminationDate());

      tableData.setAppointmentTime(request.getAppointmentTime());

      try {
        tableData = repo.save(tableData);
        response.setStatus(ResponseCode.UPDATE_APPOINTMENT_SUCCESS.getStatus());
        response.setMessage(ResponseCode.UPDATE_APPOINTMENT_SUCCESS.getMessage());

      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      response.setStatus(ResponseCode.UPDATE_APPOINTMENT_FAIL.getStatus());
      response.setMessage(ResponseCode.UPDATE_APPOINTMENT_FAIL.getMessage());
    }

    return response;
  }

  public AddAppointmentResponse deleteAppointment(String appointmentId) {

    AddAppointmentResponse response = AddAppointmentResponse.getInstance();

    Optional<Appointment> id = repo.findById(appointmentId);

    if (id.isPresent()) {

      repo.deleteById(appointmentId);
      response.setStatus(ResponseCode.DELETE_APPOINTMENT_SUCCESS.getStatus());
      response.setMessage(ResponseCode.DELETE_APPOINTMENT_SUCCESS.getMessage());
    } else {
      response.setStatus(ResponseCode.DELETE_APPOINTMENT_FAIL.getStatus());
      response.setMessage(ResponseCode.DELETE_APPOINTMENT_FAIL.getMessage());
    }

    return response;
  }

  public static String generateAppointmentId() {
    String appointmentId = "CASE";

    String alphanumericChars = "0123456789abcdefghijklmnopqrstuvwxyz";
    StringBuilder randomString = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 6; i++) {
      randomString.append(alphanumericChars.charAt(random.nextInt(alphanumericChars.length())));
    }

    appointmentId += randomString.toString();

    return appointmentId;
  }
}
