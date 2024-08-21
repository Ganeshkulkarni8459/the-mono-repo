package org.dnyanyog.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.dnyanyog.common.ResponseCode;
import org.dnyanyog.dto.AddPatientRequest;
import org.dnyanyog.dto.AddPatientResponse;
import org.dnyanyog.entity.Patient;
import org.dnyanyog.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class PatientServiceImpl implements PatientService {

  @Autowired PatientRepository repo;

  public AddPatientResponse addPatient(AddPatientRequest request) {

    AddPatientResponse response = new AddPatientResponse();

    List<Patient> mobileNumber = repo.findByMobileNumber(request.getMobileNumber());

    if (mobileNumber.isEmpty()) {

      Patient patient =
          Patient.getInstance()
              .setPatientNameInEnglish(request.getPatientNameInEnglish())
              .setPatientNameInMarathi(request.getPatientNameInMarathi())
              .setMobileNumber(request.getMobileNumber())
              .setGender(request.getGender())
              .setBirthDate(request.getBirthDate())
              .setFirstExaminationDate(request.getFirstExaminationDate())
              .setAddress(request.getAddress())
              .setPatientId(generatePatientId());

      try {
        patient = repo.save(patient);
      } catch (Exception e) {
        e.printStackTrace();
      }

      response.setPatientId(patient.getPatientId());
      response.setStatus(ResponseCode.ADD_PATIENT_SUCCESS.getStatus());
      response.setMessage(ResponseCode.ADD_PATIENT_SUCCESS.getMessage());
    } else {
      response.setStatus(ResponseCode.ADD_PATIENT_FAIL.getStatus());
      response.setMessage(ResponseCode.ADD_PATIENT_FAIL.getMessage());
    }

    return response;
  }

  public AddPatientResponse searchPatient(String patientId) {

    AddPatientResponse response = new AddPatientResponse();

    List<Patient> receivedData = repo.findBypatientId(patientId);

    if (receivedData.isEmpty()) {
      response.setStatus(ResponseCode.SEARCH_PATIENT_FAIL.getStatus());
      response.setMessage(ResponseCode.SEARCH_PATIENT_FAIL.getMessage());
    } else {
      Patient tableData = receivedData.get(0);

      response.setPatientNameInEnglish(tableData.getPatientNameInEnglish());
      response.setPatientNameInMarathi(tableData.getPatientNameInMarathi());
      response.setBirthDate(tableData.getBirthDate());
      response.setGender(tableData.getGender());
      response.setAddress(tableData.getAddress());
      response.setMobileNumber(tableData.getMobileNumber());
      response.setFirstExaminationDate(tableData.getFirstExaminationDate());

      response.setStatus(ResponseCode.SEARCH_PATIENT_SUCCESS.getStatus());
      response.setMessage(ResponseCode.SEARCH_PATIENT_SUCCESS.getMessage());
    }
    return response;
  }

  public AddPatientResponse updatePatient(String patientId, AddPatientRequest request) {

    AddPatientResponse response = new AddPatientResponse();

    List<Patient> receivedData = repo.findBypatientId(patientId);

    if (receivedData.isEmpty()) {
      response.setStatus(ResponseCode.UPDATE_PATIENT_FAIL.getStatus());
      response.setMessage(ResponseCode.UPDATE_PATIENT_FAIL.getMessage());
    } else {
      Patient tableData = receivedData.get(0);

      tableData.setPatientNameInMarathi(request.getPatientNameInMarathi());
      tableData.setBirthDate(request.getBirthDate());
      tableData.setGender(request.getGender());
      tableData.setMobileNumber(request.getMobileNumber());
      tableData.setFirstExaminationDate(request.getFirstExaminationDate());
      tableData.setAddress(request.getAddress());

      try {
        tableData = repo.save(tableData);
      } catch (Exception e) {
        e.printStackTrace();
      }

      response.setStatus(ResponseCode.UPDATE_PATIENT_SUCCESS.getStatus());
      response.setMessage(ResponseCode.UPDATE_PATIENT_SUCCESS.getMessage());
    }
    return response;
  }

  public AddPatientResponse deletePatient(String patientId) {

    AddPatientResponse response = new AddPatientResponse();

    Optional<Patient> receiedData = repo.findById(patientId);

    if (receiedData.isEmpty()) {
      response.setStatus(ResponseCode.DELETE_PATIENT_FAIL.getStatus());
      response.setMessage(ResponseCode.DELETE_PATIENT_FAIL.getMessage());
    } else {

      repo.deleteById(patientId);

      response.setStatus(ResponseCode.DELETE_PATIENT_SUCCESS.getStatus());
      response.setMessage(ResponseCode.DELETE_PATIENT_SUCCESS.getMessage());
    }

    return response;
  }

  public static String generatePatientId() {
    String patientId = "PAT";

    String alphanumericChars = "0123456789abcdefghijklmnopqrstuvwxyz";
    StringBuilder randomString = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 6; i++) {
      randomString.append(alphanumericChars.charAt(random.nextInt(alphanumericChars.length())));
    }

    patientId += randomString.toString();

    return patientId;
  }

  @Override
  public AddPatientResponse searchPatientUsingMobileNumber(Long mobileNumber) {

    AddPatientResponse response = new AddPatientResponse();

    List<Patient> patientName = repo.findByMobileNumber(mobileNumber);

    if (patientName.isEmpty()) {

      response.setStatus(ResponseCode.SEARCH_PATIENT_FAIL.getStatus());
      response.setMessage(ResponseCode.SEARCH_PATIENT_FAIL.getMessage());

    } else {
      Patient tableData = patientName.get(0);

      response.setPatientNameInEnglish(tableData.getPatientNameInEnglish());
      response.setPatientNameInMarathi(tableData.getPatientNameInMarathi());
      response.setBirthDate(tableData.getBirthDate());
      response.setGender(tableData.getGender());
      response.setAddress(tableData.getAddress());
      response.setMobileNumber(tableData.getMobileNumber());
      response.setFirstExaminationDate(tableData.getFirstExaminationDate());

      response.setStatus(ResponseCode.SEARCH_PATIENT_SUCCESS.getStatus());
      response.setMessage(ResponseCode.SEARCH_PATIENT_SUCCESS.getMessage());
    }

    return response;
  }
}
