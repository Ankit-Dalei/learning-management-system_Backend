package org.cutm.lms.Lms_Backend.Repository;

import org.cutm.lms.Lms_Backend.Entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository<Faculty,String> {
}
