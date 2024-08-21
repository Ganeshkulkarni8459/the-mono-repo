package org.dnyanyog.repository;

import java.util.Optional;
import org.dnyanyog.entity.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface CaseRepository extends JpaRepository<Cases, String> {

  Optional<Cases> findByCaseId(String caseId);

  Optional<Cases> findByPatientId(String patientId);

  Optional<Cases> findByCaseNumber(String caseNumber);
}
