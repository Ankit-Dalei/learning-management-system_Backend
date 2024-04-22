package org.cutm.lms.Lms_Backend.Controllers;


import org.cutm.lms.Lms_Backend.Entity.Branch;
import org.cutm.lms.Lms_Backend.Entity.Faculty;
import org.cutm.lms.Lms_Backend.Service.BranchMethods;
import org.cutm.lms.Lms_Backend.Service.FacultyMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cutm/branch")
@CrossOrigin("*")
public class BranchController {

    @Autowired
    private BranchMethods branchMethods;

    @PostMapping
    public ResponseEntity<Branch> createFaculty(@RequestBody Branch branch) {
        Branch branch1 = branchMethods.createBranch(branch);
        return new ResponseEntity<>(branch1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> findbyid(@PathVariable String id) {
        Branch branch = branchMethods.getBranchById(id);
        return new ResponseEntity<>(branch, HttpStatus.OK);
    }

    @GetMapping
    public List<Branch> findAll() {
        List<Branch> branches = branchMethods.getAllBranches();
        return branches;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable String id) {
        branchMethods.deleteBranch(id);
        return new ResponseEntity<>("Branch having "+id+"" +
                "deleted Successfully", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Branch> updateFaculty(@PathVariable String id,@RequestBody Branch branch) {
        Branch updateBranch = branchMethods.updateBranch(id, branch);
        return new ResponseEntity<>(updateBranch, HttpStatus.ACCEPTED);
    }
}
