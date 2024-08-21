package org.dnyanyog.controller;

import jakarta.validation.Valid;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @Autowired LoginService service;

  @PostMapping(
      path = "/api/v1/directory/validate",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public LoginResponse addPatient(@Valid @RequestBody LoginRequest request) {
    return service.loginUser(request);
  }
}
