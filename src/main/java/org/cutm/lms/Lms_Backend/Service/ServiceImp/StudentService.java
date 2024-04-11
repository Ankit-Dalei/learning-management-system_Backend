package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Entity.Student;
import org.cutm.lms.Lms_Backend.Service.StudentMethods;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements StudentMethods {
    @Override
    public Student createStudent() {

        return null;
    }

    @Override
    public Student getAdminById() {
        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        return List.of();
    }

    @Override
    public void deleteStudent(String id) {

    }

    @Override
    public Student updateStudent(String id, Student updatedAdmin) {
        return null;
    }
}
