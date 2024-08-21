package org.dnyanyog.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.dnyanyog.common.ResponseCode;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class LoginServiceImpl implements LoginService {

  @Autowired LoginResponse response;

  @Autowired LoginRepository repo;

  public LoginResponse loginUser(LoginRequest request) {

    Optional<Users> receivedData = repo.findByMobileNumber(request.getMobileNumber());

    if (receivedData.isPresent()) {
      Users data = receivedData.get();

      String encryptedPassword = data.getPassword();
      String aesKey = data.getAes_Key();

      String decryptPassword = decryptAES(encryptedPassword, aesKey);

      if (decryptPassword.equalsIgnoreCase(request.getPassword())) {
        response.setStatus(ResponseCode.LOGIN_USER_SUCCESS.getStatus());
        response.setMessage(ResponseCode.LOGIN_USER_SUCCESS.getMessage());
      } else {
        response.setStatus(ResponseCode.MOBILE_NUMBER_AND_PASSWORD_DOES_NOT_MATCH.getStatus());
        response.setMessage(ResponseCode.MOBILE_NUMBER_AND_PASSWORD_DOES_NOT_MATCH.getMessage());
      }
    } else {
      response.setStatus(ResponseCode.MOBILE_NUMBER_NOT_PRESENT.getStatus());
      response.setMessage(ResponseCode.MOBILE_NUMBER_NOT_PRESENT.getMessage());
    }

    return response;
  }

  public String decryptAES(String encryptedInput, String key) {
    try {
      Cipher cipher = Cipher.getInstance("AES");
      SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");
      cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
      byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedInput));
      return new String(decryptedBytes, StandardCharsets.UTF_8);
    } catch (Exception e) {
      throw new RuntimeException("Error decrypting with AES", e);
    }
  }
}
