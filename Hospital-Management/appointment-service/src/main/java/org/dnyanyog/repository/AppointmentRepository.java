package org.dnyanyog.repository;

import java.util.Optional;
import org.dnyanyog.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AppointmentRepository extends JpaRepository<Appointment, String> {

  Optional<Appointment> findByAppointmentId(String appointmentId);

  Optional<Appointment> findByPatientId(String patientId);
}
