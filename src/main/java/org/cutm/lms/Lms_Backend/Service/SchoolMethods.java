package org.cutm.lms.Lms_Backend.Service;

import org.cutm.lms.Lms_Backend.Entity.Management;
import org.cutm.lms.Lms_Backend.Entity.School;

import java.util.List;

public interface SchoolMethods {
    School createSchool(School school);
    School getSchool(String mtId);
    School updateSchool(String mtId,School school);
    void deleteSchool(String mtId);
    List<School> getAllSchools();
}
