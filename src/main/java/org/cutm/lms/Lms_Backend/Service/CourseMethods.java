package org.cutm.lms.Lms_Backend.Service;

import org.cutm.lms.Lms_Backend.Dto.CourseDto;

import java.util.List;

public interface CourseMethods {
    CourseDto createCourse(CourseDto courseDto);
    List<CourseDto>gellAllCourse();
    CourseDto updateCourse(CourseDto courseDto,String course_id);
    void deleteCourse(String course_id);
    CourseDto getSingleCourse(String course_id);


}
