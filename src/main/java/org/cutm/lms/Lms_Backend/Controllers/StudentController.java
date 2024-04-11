package org.cutm.lms.Lms_Backend.Controllers;

import org.cutm.lms.Lms_Backend.Entity.Admin;
import org.cutm.lms.Lms_Backend.Entity.Student;
import org.cutm.lms.Lms_Backend.Service.StudentMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cutm/student")

public class StudentController {
    @Autowired
    private StudentMethods studentMethods;
    @PostMapping
    public ResponseEntity<Student> createAdmin(@RequestBody Student student) {
        Student student1 = studentMethods.createStudent(student);
        return  new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

}
