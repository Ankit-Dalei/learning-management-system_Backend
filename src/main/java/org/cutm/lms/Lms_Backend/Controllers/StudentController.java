package org.cutm.lms.Lms_Backend.Controllers;

import org.cutm.lms.Lms_Backend.Dto.StudentDto;
import org.cutm.lms.Lms_Backend.Entity.Admin;
import org.cutm.lms.Lms_Backend.Entity.Student;
import org.cutm.lms.Lms_Backend.Service.StudentMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cutm/student")

public class StudentController {
    @Autowired
    private StudentMethods studentMethods;
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student) {
        StudentDto student1 = studentMethods.createStudent(student);
        return  new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findbyid(@PathVariable String id) {
        StudentDto student = studentMethods.getStudent(id);
        return  new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public List<StudentDto> findAll(){
        List<StudentDto> allStudent = studentMethods.getAllStudent();
        return allStudent;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id){
        studentMethods.deleteStudent(id);
        return new ResponseEntity<>("Student having "+id+"" + "deleted Successfully", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable String id,@RequestBody StudentDto student) {
        StudentDto studentDto = studentMethods.updateStudent(id, student);
        return  new ResponseEntity<>(studentDto, HttpStatus.ACCEPTED);
    }
}
