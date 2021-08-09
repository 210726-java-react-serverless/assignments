package com.revature.Jamaal_Smith_P0.screens.ProfessorScreens;

import com.revature.Jamaal_Smith_P0.screens.Screen;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;

import java.io.BufferedReader;

public class ProfCourseScreen extends Screen {
    private final UserService userService;

    public ProfCourseScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("profcourses","/profcourses", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {

        System.out.println("Welcome to the Faculty Course Management Portal\n");

        System.out.println("1 - Review Courses");
        System.out.println("2 - Add Course");
        System.out.println("3 - Delete Course");



    }
}
