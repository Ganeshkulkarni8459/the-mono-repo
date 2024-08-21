package org.dnyanyog.controller;

import jakarta.validation.Valid;
import org.dnyanyog.dto.AddCaseRequest;
import org.dnyanyog.dto.AddCaseResponse;
import org.dnyanyog.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseController {

  @Autowired CaseService service;

  @PostMapping(
      path = "/api/v1/case/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public AddCaseResponse addCase(@Valid @RequestBody AddCaseRequest request) {
    return service.addCase(request);
  }

  @GetMapping(path = "/api/v1/case/search/caseNumber/{caseNumber}")
  public AddCaseResponse searchCase(@PathVariable String caseNumber) {
    return service.searchCase(caseNumber);
  }

  @GetMapping(path = "/api/v1/case/search/patientId/{patientId}")
  public AddCaseResponse searchPatientUsingPatientId(@PathVariable String patientId) {
    return service.searchCaseUsingPatientId(patientId);
  }

  @PostMapping(
      path = "/api/v1/case/edit/{caseNumber}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public AddCaseResponse updateCase(
      @PathVariable String caseNumber, @RequestBody AddCaseRequest request) {
    return service.updateCase(caseNumber, request);
  }

  @DeleteMapping(
      path = "/api/v1/case/delete/{caseNumber}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public AddCaseResponse deleteCase(@PathVariable String caseNumber) {
    return service.deleteCase(caseNumber);
  }
}
