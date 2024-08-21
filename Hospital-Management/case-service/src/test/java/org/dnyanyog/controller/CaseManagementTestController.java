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
public class CaseManagementTestController extends AbstractTestNGSpringContextTests {

  @Autowired private MockMvc mockMvc;

  @Test
  @Order(1)
  public void CaseAddSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/case/add")
            .content(
                "<PatientCase>\r\n"
                    + "  <patientName>Onkar Lagad</patientName>\r\n"
                    + "  <patientId>12</patientId>\r\n"
                    + "  <caseNumber>455</caseNumber>\r\n"
                    + "  <examinationDate>2023-05-01</examinationDate>\r\n"
                    + "  <symptoms>Fever, cough, and sore throat</symptoms>\r\n"
                    + "  <prescription>Paracetamol 500mg</prescription>\r\n"
                    + "</PatientCase>\r\n"
                    + "")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(xpath("/AddCaseResponse/status").string("Success"))
        .andExpect(xpath("/AddCaseResponse/message").string("Case Add Sucessfully"))
        .andReturn();
  }

  @Test
  @Order(2)
  public void serachCaseSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/v1/case/search/caseNumber/19")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);
    mockMvc
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.xpath("/AddCaseResponse/status").string("Success"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddCaseResponse/message")
                .string("Case found Sucessfully "))
        .andExpect(MockMvcResultMatchers.xpath("/AddCaseResponse/patientName").string("a"))
        .andExpect(MockMvcResultMatchers.xpath("/AddCaseResponse/patientId").string("we2"))
        .andExpect(MockMvcResultMatchers.xpath("/AddCaseResponse/caseNumber").string("19"))
        .andExpect(MockMvcResultMatchers.xpath("/AddCaseResponse/symptoms").string("abbb"))
        .andExpect(MockMvcResultMatchers.xpath("/AddCaseResponse/prescription").string("a"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddCaseResponse/examinationDate").string("2022-05-11"))
        .andExpect(MockMvcResultMatchers.xpath("/AddCaseResponse/caseId").string("CASEv6fudp"))
        .andReturn();
  }

  @Test
  @Order(3)
  public void serachCaseFailXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/v1/case/search/caseNumber/P1234564")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);
    mockMvc
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.xpath("/AddCaseResponse/status").string("Fail"))
        .andExpect(MockMvcResultMatchers.xpath("/AddCaseResponse/message").string("Case not found"))
        .andReturn();
  }

  @Test
  @Order(4)
  public void CaseUpdateSuccessXml() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/appointment/edit/3")
            .content(
                "<AddCaseRequest>\r\n"
                    + "    <patientName>Onkar Lagad</patientName>\r\n"
                    + "    <patientId>PATekyrjw</patientId>\r\n"
                    + "    <caseNumber>451</caseNumber>\r\n"
                    + "    <examinationDate>2020-05-20</examinationDate>\r\n"
                    + "    <symptoms>Fever, cough, headache</symptoms>\r\n"
                    + "    <prescription>Paracetamol 00mg, twice a day</prescription>\r\n"
                    + "</AddCaseRequest>")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(xpath("/AddCaseResponse/status").string("Success"))
        .andExpect(xpath("/AddCaseResponse/message").string("Case updated Successfully"))
        .andReturn();
  }

  @Test
  @Order(5)
  public void DeleteAppointmentXml() throws Exception {

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/v1/case/delete/456")
            .contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.xpath("/AddCaseResponse/status").string("Success"))
        .andExpect(
            MockMvcResultMatchers.xpath("/AddCaseResponse/message")
                .string("Case Deleted Successfully"))
        .andReturn();
  }
}
