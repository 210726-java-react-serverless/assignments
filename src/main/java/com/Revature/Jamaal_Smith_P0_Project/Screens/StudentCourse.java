package com.Revature.Jamaal_Smith_P0_Project.Screens;

import java.io.BufferedReader;

public class StudentCourse extends Screen{
    public StudentCourse(String name, String route, BufferedReader ConsoleReader) {
        super("StudentCourse", "/StudentCourse");
    }

    @Override
    public void render() throws Exception {
        //This screen will show all course data and enable student to make selections.
        //Will populate fully after Database is created
    }
}
