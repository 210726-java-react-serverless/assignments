/** This class is closely related to the CourseRepository class and abstracts many of the
 * same functions found in the CourseRepository screen.
 */

package com.revature.Jamaal_Smith_P0.services;

import com.revature.Jamaal_Smith_P0.documents.Course;
import com.revature.Jamaal_Smith_P0.repos.CourseRepository;

public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    //Main functions that we will have to do with Courses

    /** Abstracted method that allows for a course to be located when its course number
     * is provided.
     * @param courseNumber
     * @return
     */
    public Course search (String courseNumber){
        Course courseSearch = courseRepository.findById(courseNumber);
        return courseSearch;
    }

    /** Abstracted method that allows for a course to be removed from the database when
     * its course number is provided.
     * @param course
     * @return
     */
    public Course remove(Course course){
        Course courseRemove = courseRepository.removeCourse(course.getCourseNumber());
        return courseRemove;
    }

    /** Abstracted method that allows for a student to register for a course.
     *
     * @param newCourse
     * @return
     */
    public Course register(Course newCourse){
        Course courseRegister = courseRepository.save();
        return courseRegister;
    }

    /** Abstracted method that allows for a current course to be updated.
     *
     * @param course
     * @param newCourse
     * @return
     */
    public Course update(Course course,Course newCourse){
        Course updateCourse = courseRepository.update(course,newCourse);
        return updateCourse;
    }
}





