package com.revature.Jamaal_Smith_P0.services;

import com.revature.Jamaal_Smith_P0.documents.Course;
import com.revature.Jamaal_Smith_P0.repos.CourseRepository;
import org.bson.Document;

public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    //Main functions that we will have to do with Courses

    public Course search (String courseNumber){
        Course courseSearch = courseRepository.findById(courseNumber);
        return courseSearch;
    }
    public Course remove(Course course){
        Course courseRemove = courseRepository.removeCourse(course.getCourseNumber());
        return courseRemove;
    }
    public Course register(Course newCourse){
        return courseRepository.save(newCourse);
    }

    public Course update(Course course,Course newCourse){
        Course updateCourse = courseRepository.updateCourse(course,newCourse);
        return updateCourse;
    }
}





