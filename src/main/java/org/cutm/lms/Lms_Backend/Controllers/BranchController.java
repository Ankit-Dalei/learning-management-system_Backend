package org.cutm.lms.Lms_Backend.Controllers;

import org.cutm.lms.Lms_Backend.Dto.ApiResponse;
import org.cutm.lms.Lms_Backend.Dto.BranchDto;
import org.cutm.lms.Lms_Backend.Service.BranchMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    private BranchMethods branchMethods;
    @PostMapping()
    public ResponseEntity<BranchDto> createBranch(@RequestBody BranchDto branchDto){
        BranchDto branch = branchMethods.createBranch(branchDto);
        return new ResponseEntity<>(branch, HttpStatus.CREATED);
    }
    @DeleteMapping("/{branch_id}")
    public ResponseEntity<ApiResponse>deleteBranch(@PathVariable String branch_id){
        branchMethods.deleteBranch(branch_id);
        ApiResponse responseMessage = ApiResponse.builder().message("Branch is deleted successfully !!").status(HttpStatus.OK).success(true).build();
        return new ResponseEntity<>(responseMessage,HttpStatus.OK);
    }
    @PutMapping("/{branch_id}")
    public ResponseEntity<BranchDto>updateBranch(@PathVariable String branch_id,@RequestBody BranchDto branchDto){
        BranchDto updated = branchMethods.updateBranch(branchDto, branch_id);
        return  new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
    }
    @GetMapping()
    public ResponseEntity<List<BranchDto>>getAll(){
        List<BranchDto> branchDtos = branchMethods.gellAllBranch();
        return new ResponseEntity<>(branchDtos,HttpStatus.FOUND);
    }
    @GetMapping("/{branch_id}")
    public  ResponseEntity<BranchDto>getCourse(@PathVariable String branch_id){
        BranchDto singleBranch = branchMethods.getSingleBranch(branch_id);
        return new ResponseEntity<>(singleBranch,HttpStatus.FOUND);
    }
}
