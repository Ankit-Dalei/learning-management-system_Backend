package org.cutm.lms.Lms_Backend.Controllers;

import org.cutm.lms.Lms_Backend.Entity.Faculty;
import org.cutm.lms.Lms_Backend.Service.FacultyMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> findbyid(@PathVariable String id) {
        Faculty faculty1=facultyMethods.getFacultyById(id);
        return new ResponseEntity<>(faculty1, HttpStatus.OK);
    }

    @GetMapping
    public List<Faculty> findAll() {
        List<Faculty> facultyList=facultyMethods.getAllFaculty();
        return facultyList;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable String id) {
        facultyMethods.deleteFaculty(id);
        return new ResponseEntity<>("Faculty having "+id+"" +
                "deleted Successfully", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable String id,@RequestBody Faculty faculty) {
        Faculty faculty1=facultyMethods.updateFaculty(id,faculty);
        return new ResponseEntity<>(faculty1, HttpStatus.ACCEPTED);
    }



}
