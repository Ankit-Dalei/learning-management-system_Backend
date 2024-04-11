package org.cutm.lms.Lms_Backend.Controllers;

import org.cutm.lms.Lms_Backend.Dto.ApiResponse;
import org.cutm.lms.Lms_Backend.Dto.CourseDto;
import org.cutm.lms.Lms_Backend.Service.CourseMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseMethods courseMethods;
    @PostMapping()
    public ResponseEntity<CourseDto>createCourse(@RequestBody CourseDto courseDto){
        CourseDto course = courseMethods.createCourse(courseDto);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
    @DeleteMapping("/{course_id}")
    public ResponseEntity<ApiResponse>deleteCourse(@PathVariable String course_id){
        courseMethods.deleteCourse(course_id);
        ApiResponse responseMessage = ApiResponse.builder().message("Course is deleted successfully !!").status(HttpStatus.OK).success(true).build();
        return new ResponseEntity<>(responseMessage,HttpStatus.OK);
    }
    @PutMapping("/{course_id}")
    public ResponseEntity<CourseDto>updateCourse(@PathVariable String course_id,@RequestBody CourseDto courseDto){
        CourseDto updated = courseMethods.updateCourse(courseDto, course_id);
        return  new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
    }
    @GetMapping()
    public ResponseEntity<List<CourseDto>>getAll(){
        List<CourseDto> courseDtos = courseMethods.gellAllCourse();
        return new ResponseEntity<>(courseDtos,HttpStatus.FOUND);
    }
    @GetMapping("/{course_id}")
    public  ResponseEntity<CourseDto>getCourse(@PathVariable String course_id){
        CourseDto singleCourse = courseMethods.getSingleCourse(course_id);
        return new ResponseEntity<>(singleCourse,HttpStatus.FOUND);
    }
}
