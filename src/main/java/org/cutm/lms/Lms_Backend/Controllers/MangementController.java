package org.cutm.lms.Lms_Backend.Controllers;

import org.cutm.lms.Lms_Backend.Entity.Management;
import org.cutm.lms.Lms_Backend.Service.MangementMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cutm/mangement")
@CrossOrigin("*")
public class MangementController {

    @Autowired
    private MangementMethods mangementMethods;

    @PostMapping
    public ResponseEntity<Management> createManagement(@RequestBody Management management) {
        Management newManagement = mangementMethods.createManagement(management);
        return new ResponseEntity<>(newManagement, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Management> findbyid(@PathVariable String id) {
        Management management=mangementMethods.getManagement(id);
        return new ResponseEntity<>(management, HttpStatus.FOUND);
    }

    @GetMapping
    public List<Management> findAllManagement() {
        List<Management> allManagement=mangementMethods.getAllManagement();
        return allManagement;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteManagement(@PathVariable String id) {
        mangementMethods.deleteManagement(id);
        return new ResponseEntity<>("Mangement having " + id + " deleted successfully", HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Management> updateManagement(@PathVariable String id,@RequestBody Management management) {
        Management newManagement = mangementMethods.updateManagement(id, management);
        return new ResponseEntity<>(newManagement, HttpStatus.ACCEPTED);
    }
}
