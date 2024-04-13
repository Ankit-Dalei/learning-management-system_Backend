package org.cutm.lms.Lms_Backend.Repository;

import org.cutm.lms.Lms_Backend.Dto.StudentDto;
import org.cutm.lms.Lms_Backend.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,String> {
}
