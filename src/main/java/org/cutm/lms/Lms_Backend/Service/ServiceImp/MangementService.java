package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Entity.Management;
import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Exception.ResourceNotFound;
import org.cutm.lms.Lms_Backend.Repository.MangementRepo;
import org.cutm.lms.Lms_Backend.Repository.UserRepo;
import org.cutm.lms.Lms_Backend.Service.MangementMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class MangementService implements MangementMethods {

    @Autowired
    private MangementRepo mangementRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public Management createManagement(Management management) {
        String m="MT";
        String t=String.valueOf(new Date().getTime()).substring(10,13);
        management.setMtId(m+ UUID.randomUUID().toString().substring(0,4)+t);
        management.setDateCreated(LocalDate.now());
        mangementRepo.save(management);
        User save=new User(management.getMtId(),management.getMtEmail(),management.getMtPasswd());
        userRepo.save(save);
        return management;
    }

    @Override
    public Management getManagement(String mtId) {
        Management found=mangementRepo.findById(mtId).orElseThrow(()->new ResourceNotFound("Mangement not found"));
        return found;
    }

    @Override
    public Management updateManagement(String mtId, Management management) {
        Management m=mangementRepo.findById(mtId).orElseThrow(
                ()->new ResourceNotFound("Management not found","mtId",mtId));
        m.setMtName(management.getMtName());
        m.setMtEmail(management.getMtEmail());
        m.setMtPasswd(management.getMtPasswd());
        m.setMtPhone(management.getMtPhone());
        m.setUniversityName(management.getUniversityName());
        m.setMtPhone(management.getMtPhone());
        mangementRepo.save(m);
        return m;
    }

    @Override
    public void deleteManagement(String mtId) {
        Management management=mangementRepo.findById(mtId).get();
        mangementRepo.delete(management);
        String mtId1 = management.getMtId();
        userRepo.deleteById(mtId1);
    }

    @Override
    public List<Management> getAllManagement() {
        List<Management> managements=mangementRepo.findAll();
        return managements;
    }
}
