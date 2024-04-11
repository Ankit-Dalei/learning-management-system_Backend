package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Entity.Faculty;
import org.cutm.lms.Lms_Backend.Entity.Student;
import org.cutm.lms.Lms_Backend.Entity.UserRole;
import org.cutm.lms.Lms_Backend.Repository.FacultyRepo;
import org.cutm.lms.Lms_Backend.Repository.UserRepo;
import org.cutm.lms.Lms_Backend.Service.FacultyMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FacultyService implements FacultyMethods {

    @Autowired
    private FacultyRepo facultyRepo;

    @Value("${faculty.role.id}")
    private String facultyRoleId;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Faculty createFaculty(Faculty faculty) {
        String s="FT";
        String t=String.valueOf(new Date().getTime()).substring(10,13);
        faculty.setFacultyId(s + UUID.randomUUID().toString().substring(0,4) +t);
        UserRole userRole=userRepo.findById(facultyRoleId).get();
        Faculty save=facultyRepo.save(faculty);
        return save;
    }

    @Override
    public Faculty getFacultyById(String facultyId) {
        Faculty faculty=facultyRepo.findById(facultyId).get();
        return faculty;
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
        Faculty find=facultyRepo.findById(id).get();
        if(find.getFacultyId()==faculty.getFacultyId()) {
            find.setFacultyId(faculty.getFacultyId());
            find.setFacultyPasswd(faculty.getFacultyPasswd());
            find.setFtName(faculty.getFtName());
            find.setFtPhone(faculty.getFtPhone());
            find.setFtBranch(faculty.getFtBranch());
            return find;
        }else{
            System.out.println("Faculty id not found");
            return null;
        }

    }
}
