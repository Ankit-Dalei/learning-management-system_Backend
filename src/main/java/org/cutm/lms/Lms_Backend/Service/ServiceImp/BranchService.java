package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Dto.BranchDto;
import org.cutm.lms.Lms_Backend.Entity.Branch;
import org.cutm.lms.Lms_Backend.Exception.ResourceNotFound;
import org.cutm.lms.Lms_Backend.Repository.BranchRepo;
import org.cutm.lms.Lms_Backend.Service.BranchMethods;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BranchService implements BranchMethods {
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private ModelMapper mapper;
    @Override
    public BranchDto createBranch(BranchDto branchDto) {
        String s="CUTM-BRANCH-";
        branchDto.setBranchId(s+ UUID.randomUUID().toString().substring(0,4));
        Branch branch = mapper.map(branchDto, Branch.class);
        Branch saved = branchRepo.save(branch);
        BranchDto mapped = mapper.map(saved, BranchDto.class);
        return mapped;
    }

    @Override
    public List<BranchDto> gellAllBranch() {
        List<Branch> branches = branchRepo.findAll();
        List<BranchDto> collected = branches.stream().map((item) -> mapper.map(item, BranchDto.class)).collect(Collectors.toList());
        return collected;
    }

    @Override
    public BranchDto updateBranch(BranchDto branchDto, String branch_id) {
        Branch found = branchRepo.findById(branch_id).orElseThrow(() -> new ResourceNotFound("branch id not found"));
        BranchDto branchDto1 = mapper.map(found, BranchDto.class);
        branchDto1.setBranchName(found.getBranchName());
        branchDto1.setFaculties(found.getFaculties());
        branchDto1.setStudents(found.getStudents());
        Branch save = mapper.map(branchDto1, Branch.class);
        Branch saved = branchRepo.save(save);
        BranchDto mapped = mapper.map(saved, BranchDto.class);
        return mapped;
    }

    @Override
    public void deleteBranch(String branch_id) {
        Branch found = branchRepo.findById(branch_id).orElseThrow(() -> new ResourceNotFound("given id not found"));
        branchRepo.delete(found);

    }

    @Override
    public BranchDto getSingleBranch(String branch_id) {
        Branch found = branchRepo.findById(branch_id).orElseThrow(() -> new ResourceNotFound("given id not found"));
        BranchDto dto = mapper.map(found, BranchDto.class);
        return dto;
    }
}
