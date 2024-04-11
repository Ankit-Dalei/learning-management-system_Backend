package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Entity.Student;
//import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Entity.UserRole;
import org.cutm.lms.Lms_Backend.Repository.StudentRepo;
import org.cutm.lms.Lms_Backend.Repository.UserRepo;
import org.cutm.lms.Lms_Backend.Service.StudentMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService implements StudentMethods {
    @Autowired
    private StudentRepo studentRepo;
    @Value("${student.role.id}")
    private String studentRoleId;
    @Autowired
    private UserRepo userRepo;

    @Override
    public Student createStudent(Student student) {
        String s="ST";
        String t = String.valueOf(new Date().getTime()).substring(10,13);
//        System.out.println(t)
        student.setStId(s + UUID.randomUUID().toString().substring(0,4) +t);
        UserRole userRole = userRepo.findById(studentRoleId).get();
        student.getRoles().add(userRole);
        Student save = studentRepo.save(student);
        return save;
    }

    @Override
    public Student getStudent(String studentId) {
        Student student = studentRepo.findById(studentId).get();
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = studentRepo.findAll();
        return students;
    }

    @Override
    public void deleteStudent(String id) {
        Student student = studentRepo.findById(id).get();
        studentRepo.delete(student);

    }

    @Override
    public Student updateStudent(String id, Student student) {
        return null;
    }
}
