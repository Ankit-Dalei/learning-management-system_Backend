package org.cutm.lms.Lms_Backend.Repository;
import org.cutm.lms.Lms_Backend.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<UserRole,String> {
}