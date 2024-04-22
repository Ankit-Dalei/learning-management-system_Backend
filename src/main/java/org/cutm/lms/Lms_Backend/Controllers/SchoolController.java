package org.cutm.lms.Lms_Backend.Controllers;

import org.cutm.lms.Lms_Backend.Entity.Management;
import org.cutm.lms.Lms_Backend.Entity.School;
import org.cutm.lms.Lms_Backend.Service.MangementMethods;
import org.cutm.lms.Lms_Backend.Service.SchoolMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cutm/school")
@CrossOrigin("*")
public class SchoolController {

    @Autowired
    private SchoolMethods schoolMethods;

    @PostMapping
    public ResponseEntity<School> createSchhol(@RequestBody School school) {
        School school1 = schoolMethods.createSchool(school);
        return new ResponseEntity<>(school1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> findbyid(@PathVariable String id) {
        School school = schoolMethods.getSchool(id);
        return new ResponseEntity<>(school, HttpStatus.FOUND);
    }

    @GetMapping
    public List<School> findAllManagement() {
        List<School> allSchools = schoolMethods.getAllSchools();
        return allSchools;
    }


}
