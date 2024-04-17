package org.cutm.lms.Lms_Backend.Repository;

import org.cutm.lms.Lms_Backend.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
