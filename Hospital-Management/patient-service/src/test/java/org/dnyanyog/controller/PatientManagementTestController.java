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
public class PatientManagementTestController extends AbstractTestNGSpringContextTests {

  @Autowired private MockMvc mockMvc;

  @Test
  @Order(1)
  public void patientAddSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/patient/add")
            .content(
                "<AddPatientRequest>\r\n"
                    + "    <patientNameInEnglish>John Doe</patientNameInEnglish>\r\n"
                    + "    <patientNameInMarathi>जॉन डो</patientNameInMarathi>\r\n"
                    + "    <mobileNumber>1224469410</mobileNumber>\r\n"
                    + "    <gender>Male</gender>\r\n"
                    + "    <birthDate>1990-01-01</birthDate>\r\n"
                    + "    <firstExaminationDate>2024-05-09</firstExaminationDate>\r\n"
                    + "    <address>123 Main Street, City, Country</address>\r\n"
                    + "\r\n"
                    + "</AddPatientRequest>")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(xpath("/AddPatientResponse/status").string("Success"))
        .andExpect(xpath("/AddPatientResponse/message").string("Patient Add Sucessfully"))
        .andReturn();
  }

  @Test
  @Order(2)
  public void mobileNumberAlreadyExit() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/patient/add")
            .content(
                "<AddPatientRequest>\r\n"
                    + "    <patientNameInEnglish>John Doe</patientNameInEnglish>\r\n"
                    + "    <patientNameInMarathi>जॉन डो</patientNameInMarathi>\r\n"
                    + "    <mobileNumber>1224569410</mobileNumber>\r\n"
                    + "    <gender>Male</gender>\r\n"
                    + "    <birthDate>1990-01-01</birthDate>\r\n"
                    + "    <firstExaminationDate>2024-05-09</firstExaminationDate>\r\n"
                    + "    <address>123 Main Street, City, Country</address>\r\n"
                    + "\r\n"
                    + "</AddPatientRequest>")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(xpath("/AddPatientResponse/status").string("Fail"))
        .andExpect(xpath("/AddPatientResponse/message").string("Mobile Number Is Already present"))
        .andReturn();
  }

  @Test
  @Order(3)
  public void serachPatientSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/v1/patient/search/patientId/USR0jcxfd")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);
    mockMvc
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.xpath("/AddPatientResponse/status").string("Success"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddPatientResponse/message")
                .string("Patient found Sucessfully "))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddPatientResponse/patientNameInEnglish")
                .string("Abhijeet Nirphal"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddPatientResponse/patientNameInMarathi")
                .string("जॉन iiडो"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddPatientResponse/mobileNumber").string("1234567890"))
        .andExpect(MockMvcResultMatchers.xpath("/AddPatientResponse/gender").string("Male"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddPatientResponse/birthDate").string("1990-01-01"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddPatientResponse/firstExaminationDate")
                .string("2024-05-09"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddPatientResponse/address")
                .string("123 Main Street, City, Country"))
        .andReturn();
  }

  @Test
  @Order(4)
  public void serachPatientFailXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/v1/patient/search/patientId/USR0jcxf1d")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);
    mockMvc
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.xpath("/AddPatientResponse/status").string("Fail"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddPatientResponse/message").string("Patient not found"))
        .andReturn();
  }

  @Test
  @Order(5)
  public void patientUpdateSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/patient/edit/PATeh33q0")
            .content(
                "<AddPatientRequest>\r\n"
                    + "    <patientNameInEnglish>Nirphal</patientNameInEnglish>\r\n"
                    + "    <patientNameInMarathi>जॉन iiडो</patientNameInMarathi>\r\n"
                    + "    <mobileNumber>1234567890</mobileNumber>\r\n"
                    + "    <gender>Male</gender>\r\n"
                    + "    <birthDate>1990-01-01</birthDate>\r\n"
                    + "    <firstExaminationDate>2024-05-09</firstExaminationDate>\r\n"
                    + "    <address>123 Main Street, City, Country</address>\r\n"
                    + "    <dataStatus>ACtive</dataStatus>\r\n"
                    + "</AddPatientRequest>")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(xpath("/AddPatientResponse/status").string("Success"))
        .andExpect(xpath("/AddPatientResponse/message").string("Patient updated Successfully"))
        .andReturn();
  }

  @Test
  @Order(6)
  public void deletePatientrXml() throws Exception {

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/v1/patient/delete/PATwi43ll")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.xpath("/AddPatientResponse/status").string("Success"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddPatientResponse/message")
                .string("Patient Deleted Successfully"))
        .andReturn();
  }
}
