package org.dnyanyog.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class LoginRequest {

  @NotNull(message = "Mobile number is mandatory")
  public Long mobileNumber;

  @NotNull(message = "Password is mandatory")
  public String password;

  public Long getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(Long mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
