/** This screen is designed to enable faculty with the ability to add, update and delete
 * courses from the registry.
 */
package com.revature.Jamaal_Smith_P0.screens.ProfessorScreens;

import com.revature.Jamaal_Smith_P0.documents.Course;
import com.revature.Jamaal_Smith_P0.screens.Screen;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;

import java.io.BufferedReader;

public class ProfCourseScreen extends Screen {
    private final UserService userService;
    private CourseRepository courseRepository;

    public ProfCourseScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("profcourses","/profcourses", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {

        System.out.println("Welcome to the Faculty Course Management Portal\n");

        System.out.println("1 - Edit Course");
        System.out.println("2 - Add Course");
        System.out.println("3 - Delete Course");

        String userSelection = consoleReader.readLine();

        switch(userSelection){

            case "1":
                System.out.println("Which course would you like to edit?");
                String courseUpdate = consoleReader.readLine();
                courseRepository.update(courseUpdate);
            break;

            case "2":
                System.out.println("Lets help you add a new course\n");
                System.out.println("What is the course number? ");
                String courseNumber = consoleReader.readLine();

                System.out.println("What is its department?");
                String department = consoleReader.readLine();

                System.out.println("What is its title?");
                String title = consoleReader.readLine();

                System.out.println("Who is the instructor?");
                String teacher = consoleReader.readLine();

                System.out.println("Please describe the course.");
                String description = consoleReader.readLine();

                Course newCourse = new Course(courseNumber,department,title,teacher,description);
                courseRepository.saveReal(newCourse);
                System.out.printf("newCourse");
            break;

            case "3":
                System.out.println("What is the course number that you would like remove?");
                String courseRemoval = consoleReader.readLine();
                courseRepository.removeCourse(courseRemoval);
                break;

        }




    }
}
