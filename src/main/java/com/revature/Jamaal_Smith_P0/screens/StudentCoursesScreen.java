package com.revature.Jamaal_Smith_P0.screens;

import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;

import java.io.BufferedReader;

public class StudentCoursesScreen extends Screen{

    private final UserService userService;

    public StudentCoursesScreen(String name, String route, BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("studentCourses","/studentCourses", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {

    }
}
