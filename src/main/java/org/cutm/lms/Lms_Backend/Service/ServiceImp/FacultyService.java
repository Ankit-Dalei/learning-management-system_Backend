package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Entity.Faculty;
import org.cutm.lms.Lms_Backend.Entity.User;
import org.cutm.lms.Lms_Backend.Entity.UserRole;
import org.cutm.lms.Lms_Backend.Exception.ResourceNotFound;
import org.cutm.lms.Lms_Backend.Repository.FacultyRepo;
import org.cutm.lms.Lms_Backend.Repository.RoleRepo;
import org.cutm.lms.Lms_Backend.Repository.UserRepo;
import org.cutm.lms.Lms_Backend.Service.FacultyMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FacultyService implements FacultyMethods {

    @Autowired
    private FacultyRepo facultyRepo;

    @Value("${faculty.role.id}")
    private String facultyRoleId;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Faculty createFaculty(Faculty faculty) {
        String s="FT";
        String t=String.valueOf(new Date().getTime()).substring(10,13);
        faculty.setFacultyId(s + UUID.randomUUID().toString().substring(0,4) +t);
//        UserRole userRole=roleRepo.findById(facultyRoleId).get();
//        User user=userRepo.findById(faculty.getFacultyId()).get();
//        roleRepo.save(userRole);
        Faculty save=facultyRepo.save(faculty);
        User user1 = new User(save.getFacultyId(), save.getFacultyEmail(), save.getFacultyPasswd());
        userRepo.save(user1);
        return save;
    }

    @Override
    public Faculty getFacultyById(String facultyId) {
        Optional<Faculty> find = facultyRepo.findById(facultyId);
        if (find.isPresent()){
            return find.get();
        }else{
            throw new ResourceNotFound("Faculty","Id",facultyId);
        }
    }

    @Override
    public List<Faculty> getAllFaculty() {
        List<Faculty> faculties = facultyRepo.findAll();
        return faculties;
    }

    @Override
    public void deleteFaculty(String id) {
        Faculty faculty=facultyRepo.findById(id).get();
        facultyRepo.delete(faculty);
    }

    @Override
    public Faculty updateFaculty(String id, Faculty faculty) {
        Faculty find=facultyRepo.findById(id).orElseThrow(
                ()->new ResourceNotFound("Faculty","id",id));

        find.setFacultyId(faculty.getFacultyId());
        find.setFacultyPasswd(faculty.getFacultyPasswd());
        find.setFtName(faculty.getFtName());
        find.setFtPhone(faculty.getFtPhone());
        find.setFtBranch(faculty.getFtBranch());

        return find;


    }
}
