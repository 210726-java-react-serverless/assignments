package com.Revature.Jamaal_Smith_P0_Project.Screens;

import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;

import java.io.BufferedReader;

public class StudentCourse extends Screen{
    public StudentCourse(BufferedReader consoleReader, ScreenRouter router) {
        super("StudentCourse", "/StudentCourse", consoleReader,router);
    }

    @Override
    public void render() throws Exception {
        //This screen will show all course data and enable student to make selections.
        //Will populate fully after Database is created
    }
}
