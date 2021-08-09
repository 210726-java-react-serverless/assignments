package com.revature.Jamaal_Smith_P0.screens.StudentScreens;

import com.revature.Jamaal_Smith_P0.screens.Screen;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;

import java.io.BufferedReader;

public class StudentCoursesScreen extends Screen {

    private final UserService userService;

    public StudentCoursesScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("studentCourses","/studentCourses", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {

        System.out.println("Welcome to the Student Course Management Portal\n");

        System.out.println("What would you like to do today?\n");

        System.out.println("1 - Review Courses");
        System.out.println("2 - Enroll in Course");
        System.out.println("3 - Disenroll in Course");


    }
}
