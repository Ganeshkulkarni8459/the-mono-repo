package org.dnyanyog.service;

import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;

public interface UserService {

  public AddUserResponse addUser(AddUserRequest request);

  public AddUserResponse searchUser(String userId);

  public AddUserResponse updateUser(String userId, AddUserRequest request);

  public AddUserResponse deleteUser(String userId);
}
