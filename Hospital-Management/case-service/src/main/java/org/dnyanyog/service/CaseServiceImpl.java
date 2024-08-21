package org.dnyanyog.service;

import java.util.Optional;
import java.util.Random;
import org.dnyanyog.common.ResponseCode;
import org.dnyanyog.dto.AddCaseRequest;
import org.dnyanyog.dto.AddCaseResponse;
import org.dnyanyog.entity.Cases;
import org.dnyanyog.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CaseServiceImpl implements CaseService {

  @Autowired CaseRepository repo;

  @Autowired AddCaseResponse response;

  public AddCaseResponse addCase(AddCaseRequest request) {

    AddCaseResponse response = AddCaseResponse.getInstance();

    Cases requestData =
        Cases.getInstance()
            .setPatientName(request.getPatientName())
            .setPatientId(request.getPatientId())
            .setCaseNumber(request.getCaseNumber())
            .setExaminationDate(request.getExaminationDate())
            .setSymptoms(request.getSymptoms())
            .setPrescription(request.getPrescription())
            .setCaseId(generateCaseId());

    try {
      requestData = repo.save(requestData);
      response.setStatus(ResponseCode.ADD_CASE_SUCCESS.getStatus());
      response.setMessage(ResponseCode.ADD_CASE_SUCCESS.getMessage());
      response.setCaseId(requestData.getCaseId());

    } catch (Exception e) {
      e.printStackTrace();
    }

    return response;
  }

  public AddCaseResponse searchCase(String caseNumber) {

    AddCaseResponse response = AddCaseResponse.getInstance();

    Optional<Cases> id = repo.findByCaseNumber(caseNumber);

    if (id.isPresent()) {
      Cases receivedData = id.get();

      response.setPatientName(receivedData.getPatientName());
      response.setPatientId(receivedData.getPatientId());
      response.setCaseNumber(receivedData.getCaseNumber());
      response.setSymptoms(receivedData.getSymptoms());
      response.setPrescription(receivedData.getPrescription());
      response.setExaminationDate(receivedData.getExaminationDate());
      response.setCaseId(receivedData.getCaseId());

      response.setStatus(ResponseCode.SEARCH_CASE_SUCCESS.getStatus());
      response.setMessage(ResponseCode.SEARCH_CASE_SUCCESS.getMessage());
    } else {
      response.setStatus(ResponseCode.SEARCH_CASE_FAIL.getStatus());
      response.setMessage(ResponseCode.SEARCH_CASE_FAIL.getMessage());
    }

    return response;
  }

  public AddCaseResponse searchCaseUsingPatientId(String patientId) {

    AddCaseResponse response = AddCaseResponse.getInstance();

    Optional<Cases> id = repo.findByPatientId(patientId);

    if (id.isPresent()) {
      Cases receivedData = id.get();

      response.setPatientName(receivedData.getPatientName());
      response.setPatientId(receivedData.getPatientId());
      response.setCaseNumber(receivedData.getCaseNumber());
      response.setSymptoms(receivedData.getSymptoms());
      response.setPrescription(receivedData.getPrescription());
      response.setExaminationDate(receivedData.getExaminationDate());
      response.setCaseId(receivedData.getCaseId());

      response.setStatus(ResponseCode.SEARCH_CASE_SUCCESS.getStatus());
      response.setMessage(ResponseCode.SEARCH_CASE_SUCCESS.getMessage());
    } else {
      response.setStatus(ResponseCode.SEARCH_CASE_FAIL.getStatus());
      response.setMessage(ResponseCode.SEARCH_CASE_FAIL.getMessage());
    }

    return response;
  }

  public AddCaseResponse updateCase(String caseNumber, AddCaseRequest request) {
    AddCaseResponse response = AddCaseResponse.getInstance();

    Optional<Cases> id = repo.findByCaseNumber(caseNumber);

    if (id.isPresent()) {
      Cases receivedData = id.get();

      receivedData.setPatientName(request.getPatientName());
      receivedData.setPatientId(request.getPatientId());
      receivedData.setSymptoms(request.getSymptoms());
      receivedData.setPrescription(request.getPrescription());
      receivedData.setExaminationDate(request.getExaminationDate());

      try {
        receivedData = repo.save(receivedData);
      } catch (Exception e) {
        e.printStackTrace();
      }

      response.setStatus(ResponseCode.UPDATE_CASE_SUCCESS.getStatus());
      response.setMessage(ResponseCode.UPDATE_CASE_SUCCESS.getMessage());
    } else {
      response.setStatus(ResponseCode.UPDATE_CASE_FAIL.getStatus());
      response.setMessage(ResponseCode.UPDATE_CASE_FAIL.getMessage());
    }

    return response;
  }

  public AddCaseResponse deleteCase(String caseNumber) {

    AddCaseResponse response = AddCaseResponse.getInstance();

    Optional<Cases> id = repo.findById(caseNumber);

    if (id.isPresent()) {

      repo.deleteById(caseNumber);
      response.setStatus(ResponseCode.DELETE_CASE_SUCCESS.getStatus());
      response.setMessage(ResponseCode.DELETE_CASE_SUCCESS.getMessage());
    } else {
      response.setStatus(ResponseCode.DELETE_CASE_FAIL.getStatus());
      response.setMessage(ResponseCode.DELETE_CASE_FAIL.getMessage());
    }

    return response;
  }

  public static String generateCaseId() {
    String caseId = "CASE";

    String alphanumericChars = "0123456789abcdefghijklmnopqrstuvwxyz";
    StringBuilder randomString = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 6; i++) {
      randomString.append(alphanumericChars.charAt(random.nextInt(alphanumericChars.length())));
    }

    caseId += randomString.toString();

    return caseId;
  }
}
