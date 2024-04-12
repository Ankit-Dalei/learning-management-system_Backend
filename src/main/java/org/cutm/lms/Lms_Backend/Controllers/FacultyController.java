package org.cutm.lms.Lms_Backend.Controllers;

import org.cutm.lms.Lms_Backend.Entity.Faculty;
import org.cutm.lms.Lms_Backend.Service.FacultyMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cutm/faculty")
public class FacultyController {
    @Autowired
    private FacultyMethods facultyMethods;

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty faculty1=facultyMethods.createFaculty(faculty);
        return new ResponseEntity<>(faculty1, HttpStatus.CREATED);
    }



}
