package org.dnyanyog.repository;

import java.util.List;
import java.util.Optional;
import org.dnyanyog.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface PatientRepository extends JpaRepository<Patient, String> {

  List<Patient> findBypatientId(String patientId);

  List<Patient> findByMobileNumber(Long mobileNumber);

  Optional<Patient> findByPatientNameInEnglish(String name);
}
