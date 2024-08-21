package org.dnyanyog.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.dnyanyog.common.ResponseCode;
import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserServiceImpl implements UserService {

  @Autowired UsersRepository repo;

  public AddUserResponse addUser(AddUserRequest request) {

    AddUserResponse response = new AddUserResponse();

    Optional<Users> mobileNumber = repo.findByMobileNumber(request.getMobileNumber());

    if (mobileNumber.isPresent()) {
      response.setStatus(ResponseCode.ADD_USER_FAIL.getStatus());
      response.setMessage(ResponseCode.ADD_USER_FAIL.getMessage());
    } else {

      String aesKey = generateAESKey();

      Users user =
          Users.getInstance()
              .setUserName(request.getUserName())
              .setEmail(request.getEmail())
              .setMobileNumber(request.getMobileNumber())
              .setRole(request.getRole())
              .setPassword(encryptAES(request.getPassword(), aesKey))
              .setAes_Key(aesKey)
              .setUserId(generateUserId());

      try {
        user = repo.save(user);
      } catch (Exception e) {
        e.printStackTrace();
      }

      response.setStatus(ResponseCode.ADD_USER_SUCCESS.getStatus());
      response.setMessage(ResponseCode.ADD_USER_SUCCESS.getMessage());
      response.setUserId(user.getUserId());
    }

    return response;
  }

  public AddUserResponse searchUser(String userId) {

    AddUserResponse response = new AddUserResponse();

    Optional<Users> user = repo.findById(userId);

    if (user.isPresent()) {

      Users receivedData = user.get();

      response.setStatus(ResponseCode.SEARCH_USER_SUCCESS.getStatus());
      response.setMessage(ResponseCode.SEARCH_USER_SUCCESS.getMessage());
      response.setUserName(receivedData.getUserName());
      response.setEmail(receivedData.getEmail());
      response.setMobileNumber(receivedData.getMobileNumber());
      response.setRole(receivedData.getRole());
      response.setPassword(receivedData.getPassword());

    } else {
      response.setStatus(ResponseCode.SEARCH_USER_FAIL.getStatus());
      response.setMessage(ResponseCode.SEARCH_USER_FAIL.getMessage());
    }
    return response;
  }

  public AddUserResponse updateUser(String userId, AddUserRequest request) {

    AddUserResponse response = new AddUserResponse();

    Optional<Users> user = repo.findById(userId);

    if (user.isPresent()) {
      Users receivedData = user.get();

      String aesKey = receivedData.getAes_Key();

      receivedData.setUserName(request.getUserName());
      receivedData.setEmail(request.getEmail());
      receivedData.setRole(request.getEmail());
      receivedData.setMobileNumber(request.getMobileNumber());
      receivedData.setPassword(encryptAES(request.getPassword(), aesKey));

      try {
        receivedData = repo.save(receivedData);
      } catch (Exception e) {
        e.printStackTrace();
      }

      response.setStatus(ResponseCode.UPDATE_USER_SUCCESS.getStatus());
      response.setMessage(ResponseCode.UPDATE_USER_SUCCESS.getMessage());
    } else {
      response.setStatus(ResponseCode.UPDATE_USER_FAIL.getStatus());
      response.setMessage(ResponseCode.UPDATE_USER_FAIL.getMessage());
    }

    return response;
  }

  public AddUserResponse deleteUser(String userId) {

    AddUserResponse response = new AddUserResponse();

    Optional<Users> user = repo.findById(userId);

    if (user.isPresent()) {
      repo.deleteById(userId);

      response.setStatus(ResponseCode.DELETE_USER_SUCCESS.getStatus());
      response.setMessage(ResponseCode.DELETE_USER_SUCCESS.getMessage());
    } else {
      response.setStatus(ResponseCode.DELETE_USER_FAIL.getStatus());
      response.setMessage(ResponseCode.DELETE_USER_FAIL.getMessage());
    }
    return response;
  }

  public static String generateUserId() {
    String userId = "USR";

    String alphanumericChars = "0123456789abcdefghijklmnopqrstuvwxyz";
    StringBuilder randomString = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 6; i++) {
      randomString.append(alphanumericChars.charAt(random.nextInt(alphanumericChars.length())));
    }

    userId += randomString.toString();

    return userId;
  }

  private String encryptAES(String input, String key) {
    try {
      Cipher cipher = Cipher.getInstance("AES");
      SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");
      cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
      byte[] encryptedBytes = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
      return Base64.getEncoder().encodeToString(encryptedBytes);
    } catch (Exception e) {
      throw new RuntimeException("Error encrypting with AES", e);
    }
  }

  private String generateAESKey() {
    try {
      KeyGenerator keyGen = KeyGenerator.getInstance("AES");
      keyGen.init(256);
      SecretKey secretKey = keyGen.generateKey();
      byte[] encodedKey = secretKey.getEncoded();
      return Base64.getEncoder().encodeToString(encodedKey);
    } catch (Exception e) {
      throw new RuntimeException("Error generating AES key", e);
    }
  }
}
