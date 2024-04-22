package org.cutm.lms.Lms_Backend.Repository;

import org.cutm.lms.Lms_Backend.Entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School, String> {
}
