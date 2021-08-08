package com.revature.Jamaal_Smith_P0.screens;

import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;

import java.io.BufferedReader;

public class ProfCoursesScreen {
    private UserService userService;



    public ProfCoursesScreen(String name, String route, BufferedReader consoleReader, ScreenRouter router, UserService userService){
        super("profCourses","/profCourses",consoleReader,router)
        this.userService = userService;
    }
}
