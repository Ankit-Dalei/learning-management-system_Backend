package org.cutm.lms.Lms_Backend.Service;


import org.cutm.lms.Lms_Backend.Dto.BranchDto;

import java.util.List;

public interface BranchMethods {
    BranchDto createBranch(BranchDto branchDto);
    List<BranchDto> gellAllBranch();
    BranchDto updateBranch(BranchDto branchDto,String branch_id);
    void deleteBranch(String branch_id);
    BranchDto getSingleBranch(String branch_id);
}
