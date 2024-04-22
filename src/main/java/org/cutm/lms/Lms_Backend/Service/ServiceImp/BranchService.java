package org.cutm.lms.Lms_Backend.Service.ServiceImp;


import org.cutm.lms.Lms_Backend.Dto.StudentDto;
import org.cutm.lms.Lms_Backend.Entity.Branch;
import org.cutm.lms.Lms_Backend.Entity.Student;
//import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Entity.UserRole;
import org.cutm.lms.Lms_Backend.Exception.ResourceNotFound;
import org.cutm.lms.Lms_Backend.Repository.BranchRepo;
import org.cutm.lms.Lms_Backend.Repository.RoleRepo;
import org.cutm.lms.Lms_Backend.Repository.StudentRepo;
import org.cutm.lms.Lms_Backend.Repository.UserRepo;
import org.cutm.lms.Lms_Backend.Service.BranchMethods;
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
public class BranchService implements BranchMethods {
    @Autowired
    private BranchRepo branchRepo;



    @Override
    public Branch createBranch(Branch branch) {
        branch.setBhId(UUID.randomUUID().toString().substring(0,5));
        Branch save = branchRepo.save(branch);
        return save;
    }

    @Override
    public Branch getBranchById(String branchId) {
        Branch branch = branchRepo.findById(branchId).orElseThrow(()->new ResourceNotFound("branch id not found"));
        return branch;
    }

    @Override
    public List<Branch> getAllBranches() {
        List<Branch> branches = branchRepo.findAll();
        return branches;
    }

    @Override
    public void deleteBranch(String id) {
        branchRepo.deleteById(id);

    }

    @Override
    public Branch updateBranch(String id, Branch branch) {
        Branch found = branchRepo.findById(id).orElseThrow(() -> new ResourceNotFound("branch id not found"));
        found.setBhName(branch.getBhName());
        found.setBhDesc(branch.getBhDesc());
        Branch save = branchRepo.save(found);
        return save;
    }
}
