package org.cutm.lms.Lms_Backend.Service.ServiceImp;

import org.cutm.lms.Lms_Backend.Dto.CourseDto;
import org.cutm.lms.Lms_Backend.Entity.Course;
import org.cutm.lms.Lms_Backend.Exception.ResourceNotFound;
import org.cutm.lms.Lms_Backend.Repository.CourseRepo;
import org.cutm.lms.Lms_Backend.Service.CourseMethods;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseService implements CourseMethods {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        String s="CUTM-";
        courseDto.setCourseId(s+UUID.randomUUID().toString().substring(0,4));
        Course course = mapper.map(courseDto, Course.class);
        Course save = courseRepo.save(course);
        CourseDto mapped = mapper.map(save,CourseDto.class);
        return mapped;
    }

    @Override
    public List<CourseDto> gellAllCourse() {
        List<Course> courseList = courseRepo.findAll();
        List<CourseDto> courseDtos = courseList.stream().map((item)->mapper.map(item, CourseDto.class)).collect(Collectors.toList());
        return courseDtos;
    }

    @Override
    public CourseDto updateCourse(CourseDto course, String course_id) {
        Course course1 = courseRepo.findById(course_id).orElseThrow(() -> new ResourceNotFound("course not found"));
        CourseDto courseDto = mapper.map(course1, CourseDto.class);
        courseDto.setCourseName(course.getCourseName());
        courseDto.setCourseCategory(course.getCourseCategory());
        courseDto.setFaculty(course.getFaculty());
        Course save = mapper.map(courseDto, Course.class);
        Course save1 = courseRepo.save(save);
        CourseDto mapped = mapper.map(save1, CourseDto.class);
        return mapped;
    }

    @Override
    public void deleteCourse(String course_id) {
        Course found = courseRepo.findById(course_id).orElseThrow(() -> new ResourceNotFound("given id not found"));
        courseRepo.delete(found);
    }

    @Override
    public CourseDto getSingleCourse(String course_id) {
        Course found = courseRepo.findById(course_id).orElseThrow(() -> new ResourceNotFound("given id not found"));
        CourseDto dto = mapper.map(found, CourseDto.class);
        return dto;
    }
}
