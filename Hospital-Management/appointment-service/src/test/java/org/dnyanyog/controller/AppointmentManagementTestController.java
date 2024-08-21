package org.dnyanyog.controller;

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
public class AppointmentManagementTestController extends AbstractTestNGSpringContextTests {

  @Autowired private MockMvc mockMvc;

  @Test
  @Order(1)
  public void AppointmentAddSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/appointment/add")
            .content(
                "<AddAppointmentRequest>\r\n"
                    + "    <patientName>John Doe</patientName>\r\n"
                    + "    <patientId>P123452164</patientId>\r\n"
                    + "    <appointmentId>2</appointmentId>\r\n"
                    + "    <examinationDate>2024-05-30</examinationDate>\r\n"
                    + "    <appointmentTime>10:00 AM</appointmentTime>\r\n"
                    + "</AddAppointmentRequest>")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(xpath("/AddAppointmentResponse/status").string("Success"))
        .andExpect(xpath("/AddAppointmentResponse/message").string("Appointment Add Sucessfully"))
        .andReturn();
  }

  @Test
  @Order(2)
  public void serachAppointmentSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/v1/appointment/search/appointmentId/P1234564")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);
    mockMvc
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.xpath("/AddAppointmentResponse/status").string("Success"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddAppointmentResponse/message")
                .string("Appointment found Sucessfully "))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddAppointmentResponse/patientName").string("John Doe"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddAppointmentResponse/patientId").string("P123456422"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddAppointmentResponse/appointmentTime")
                .string("10:00 AM"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddAppointmentResponse/appointmentId").string("P1234564"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddAppointmentResponse/examinationDate")
                .string("2024-05-30"))
        .andReturn();
  }

  @Test
  @Order(3)
  public void serachAppointmentFailXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/v1/appointment/search/appointmentId/USR0jcxf1d")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);
    mockMvc
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.xpath("/AddAppointmentResponse/status").string("Fail"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddAppointmentResponse/message")
                .string("Appointment not found"))
        .andReturn();
  }

  @Test
  @Order(4)
  public void appointmentUpdateSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/appointment/edit/2")
            .content(
                "<AddAppointmentRequest>\r\n"
                    + "    <patientName>John Doe</patientName>\r\n"
                    + "    <patientId>P123452164</patientId>\r\n"
                    + "    <appointmentId>2</appointmentId>\r\n"
                    + "    <examinationDate>2024-05-30</examinationDate>\r\n"
                    + "    <appointmentTime>10:00 AM</appointmentTime>\r\n"
                    + "</AddAppointmentRequest>")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(xpath("/AddAppointmentResponse/status").string("Success"))
        .andExpect(
            xpath("/AddAppointmentResponse/message").string("Appointment updated Successfully"))
        .andReturn();
  }

  @Test
  @Order(5)
  public void deleteAppointmentXml() throws Exception {

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/v1/appointment/delete/P123456422")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.xpath("/AddAppointmentResponse/status").string("Success"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddAppointmentResponse/message")
                .string("Appointment Deleted Successfully"))
        .andReturn();
  }
}
