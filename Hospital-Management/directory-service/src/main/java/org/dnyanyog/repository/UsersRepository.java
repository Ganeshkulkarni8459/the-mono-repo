package org.dnyanyog.repository;

import java.util.Optional;
import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UsersRepository extends JpaRepository<Users, String> {

  Optional<Users> findByMobileNumber(Long mobileNumber);

  Optional<Users> findById(String userId);
}
