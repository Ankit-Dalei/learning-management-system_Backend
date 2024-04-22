package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Entity.School;
import org.cutm.lms.Lms_Backend.Repository.SchoolRepo;
import org.cutm.lms.Lms_Backend.Service.SchoolMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class SchoolService implements SchoolMethods {
    @Autowired
    private SchoolRepo schoolRepo;
    @Override
    public School createSchool(School school) {
        school.setScId(new Date().toString().substring(2,6));
        School save = schoolRepo.save(school);
        return save;
    }

    @Override
    public School getSchool(String mtId) {
        School found = schoolRepo.findById(mtId).orElseThrow(() -> new RuntimeException("School not found"));
        return found;
    }

    @Override
    public School updateSchool(String mtId, School school) {
        School found = schoolRepo.findById(mtId).orElseThrow(() -> new RuntimeException("School not found"));
        found.setScName(school.getScName());
        found.setScDesc(school.getScDesc());
        found.setScEmail(school.getScEmail());
        return found;
    }

    @Override
    public void deleteSchool(String mtId) {
        schoolRepo.deleteById(mtId);

    }

    @Override
    public List<School> getAllSchools() {
        List<School> all = schoolRepo.findAll();
        return all;
    }
}
