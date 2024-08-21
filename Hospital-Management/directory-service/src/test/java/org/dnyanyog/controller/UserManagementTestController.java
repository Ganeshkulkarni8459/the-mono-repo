package org.dnyanyog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserManagementTestController extends AbstractTestNGSpringContextTests {

  @Autowired private MockMvc mockMvc;

  @Test
  @Order(1)
  public void userAddSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/directory/add")
            .content(
                "<AddUserRequest>\r\n"
                    + "    <userName>JohnDoe</userName>\r\n"
                    + "    <email>john.doe@example.com</email>\r\n"
                    + "    <mobileNumber>8547476528</mobileNumber>\r\n"
                    + "    <role>Admin</role>\r\n"
                    + "    <password>123</password>\r\n"
                    + "</AddUserRequest>")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(xpath("/AddUserResponse/status").string("Success"))
        .andExpect(xpath("/AddUserResponse/message").string("User Add Sucessfully"))
        .andReturn();
  }

  @Test
  @Order(2)
  public void mobileNumberAlreadyExit() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/directory/add")
            .content(
                "<AddUserRequest>\\r\\n\"\r\n"
                    + "                    + \"    <userName>JohnDoe</userName>\\r\\n\"\r\n"
                    + "                    + \"    <email>john.doe@example.com</email>\\r\\n\"\r\n"
                    + "                    + \"    <mobileNumber>5247496528</mobileNumber>\\r\\n\"\r\n"
                    + "                    + \"    <role>Admin</role>\\r\\n\"\r\n"
                    + "                    + \"    <password>123</password>\\r\\n\"\r\n"
                    + "                    + \"</AddUserRequest>")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(xpath("/AddUserResponse/status").string("Fail"))
        .andExpect(xpath("/AddUserResponse/message").string("Mobile Number Already Exit"))
        .andReturn();
  }

  @Test
  @Order(3)
  public void serachUserSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/v1/directory/search/USR0jcxfd")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);
    mockMvc
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.xpath("/AddUserResponse/status").string("Success"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddUserResponse/message")
                .string("User found Sucessfully "))
        .andExpect(MockMvcResultMatchers.xpath("/AddUserResponse/userName").string("qwe"))
        .andExpect(MockMvcResultMatchers.xpath("/AddUserResponse/email").string("abhi5@gmail.com"))
        .andExpect(MockMvcResultMatchers.xpath("/AddUserResponse/role").string("student"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddUserResponse/mobileNumber").string("7452639874"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddUserResponse/password")
                .string("VkcgzrnAVeiK2mIAR9VjLw=="))
        .andReturn();
  }

  @Test
  @Order(4)
  public void userNotFoundXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/v1/directory/search/USR0jcxfd1")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);
    mockMvc
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.xpath("/AddUserResponse/status").string("Fail"))
        .andExpect(MockMvcResultMatchers.xpath("/AddUserResponse/message").string("User not found"))
        .andReturn();
  }

  @Test
  @Order(5)
  public void userUpdateSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/directory/edit/USR61ubcu")
            .content(
                "<AddUserRequest>\r\n"
                    + "    <userName>JohnDoe</userName>\r\n"
                    + "    <email>john.doe@example.com</email>\r\n"
                    + "    <mobileNumber>5247406528</mobileNumber>\r\n"
                    + "    <role>Admin</role>\r\n"
                    + "    <password>123</password>\r\n"
                    + "</AddUserRequest>")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(xpath("/AddUserResponse/status").string("Success"))
        .andExpect(xpath("/AddUserResponse/message").string("User updated Successfully"))
        .andReturn();
  }

  @Test
  @Order(6)
  public void deleteUserXml() throws Exception {

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/v1/directory/delete/USR7yx14s")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.xpath("/AddUserResponse/status").string("Success"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddUserResponse/message")
                .string("User Deleted Successfully"))
        .andReturn();
  }

  @Test
  @Order(7)
  public void loginSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/directory/validate")
            .content(
                "<LoginRequest>\r\n"
                    + "    <mobileNumber>7894561230</mobileNumber> \r\n"
                    + "    <password>123</password>\r\n"
                    + "</LoginRequest>")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(xpath("/LoginResponse/status").string("Success"))
        .andExpect(xpath("/LoginResponse/message").string("Login Successfully"))
        .andReturn();
  }

  @Test
  @Order(8)
  public void loginFailXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/directory/validate")
            .content(
                "<LoginRequest>\r\n"
                    + "    <mobileNumber>7894551230</mobileNumber> \r\n"
                    + "    <password>223</password>\r\n"
                    + "</LoginRequest>")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(xpath("/LoginResponse/status").string("Fail"))
        .andExpect(xpath("/LoginResponse/message").string("Mobile Number Does Not Exit"))
        .andReturn();
  }
}
