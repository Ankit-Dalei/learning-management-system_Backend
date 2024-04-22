package org.cutm.lms.Lms_Backend.Service;

import org.cutm.lms.Lms_Backend.Entity.Branch;
import org.cutm.lms.Lms_Backend.Entity.Faculty;

import java.util.List;

public interface BranchMethods {
    Branch createBranch(Branch branch);


    Branch getBranchById(String branchId);

    List<Branch> getAllBranches();

    void deleteBranch(String id);

    Branch updateBranch(String id,Branch branch);
}
