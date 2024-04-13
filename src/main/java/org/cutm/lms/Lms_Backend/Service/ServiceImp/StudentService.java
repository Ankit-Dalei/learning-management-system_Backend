package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Dto.StudentDto;
import org.cutm.lms.Lms_Backend.Entity.Student;
//import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Entity.UserRole;
import org.cutm.lms.Lms_Backend.Exception.ResourceNotFound;
import org.cutm.lms.Lms_Backend.Repository.StudentRepo;
import org.cutm.lms.Lms_Backend.Repository.UserRepo;
import org.cutm.lms.Lms_Backend.Service.StudentMethods;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService implements StudentMethods {
    @Autowired
    private StudentRepo studentRepo;
    @Value("${student.role.id}")
    private String studentRoleId;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto createStudent(StudentDto student) {
        String s="ST";
        String t = String.valueOf(new Date().getTime()).substring(10,13);
//        System.out.println(t)
        student.setStId(s + UUID.randomUUID().toString().substring(0,4) +t);
        UserRole userRole = userRepo.findById(studentRoleId).get();
        student.getRoles().add(userRole);
        Student mapped = modelMapper.map(student, Student.class);
        Student save = studentRepo.save(mapped);
        StudentDto studentDto = modelMapper.map(save, StudentDto.class);
        return studentDto;
    }

    @Override
    public StudentDto getStudent(String studentId) {
        Student found = studentRepo.findById(studentId).orElseThrow(() -> new ResourceNotFound("Student not found"));
        return modelMapper.map(found, StudentDto.class);

    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepo.findAll();
        List<StudentDto> collect = students.stream().map(object -> new ModelMapper().map(object, StudentDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteStudent(String id) {
        Student student = studentRepo.findById(id).get();
        studentRepo.delete(student);

    }

    @Override
    public StudentDto updateStudent(String id, StudentDto student) {
        Student stud = studentRepo.findById(id).orElseThrow(
                ()->new ResourceNotFound("Student","id",id));
        stud.setStName(student.getStName());
        stud.setStEmail(student.getStEmail());
        stud.setStPhone(student.getStPhone());
        stud.setStBranch(student.getStBranch());
        stud.setStBatch(student.getStBatch());
        stud.setStPasswd(student.getStPasswd());
        stud.setStSection(student.getStSection());
        StudentDto studentDto = modelMapper.map(stud, StudentDto.class);
        return studentDto;
    }
}
