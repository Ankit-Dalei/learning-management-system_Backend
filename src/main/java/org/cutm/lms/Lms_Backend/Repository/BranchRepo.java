package org.cutm.lms.Lms_Backend.Repository;

import org.cutm.lms.Lms_Backend.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch,String> {
}
