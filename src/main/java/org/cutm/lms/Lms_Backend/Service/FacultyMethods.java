package org.cutm.lms.Lms_Backend.Service;

import org.cutm.lms.Lms_Backend.Entity.Faculty;

import java.util.List;

public interface FacultyMethods {
    Faculty createFaculty(Faculty faculty);

    //Get the Particular Faculty Using Id
    Faculty getFacultyById(String facultyId);

    //Get all the Faculty Details
    List<Faculty> getAllFaculty();

    //Delete any particular Faculty using Id
    void deleteFaculty(String id);

    //Update any particular Faculty using id
    Faculty updateFaculty(String id,Faculty faculty);

}
