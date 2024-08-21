package org.dnyanyog.service;

import org.dnyanyog.dto.AddPatientRequest;
import org.dnyanyog.dto.AddPatientResponse;

public interface PatientService {

  public AddPatientResponse addPatient(AddPatientRequest request);

  public AddPatientResponse searchPatient(String patientId);

  public AddPatientResponse searchPatientUsingMobileNumber(Long mobileNUmber);

  public AddPatientResponse updatePatient(String patientId, AddPatientRequest request);

  public AddPatientResponse deletePatient(String patientId);
}
