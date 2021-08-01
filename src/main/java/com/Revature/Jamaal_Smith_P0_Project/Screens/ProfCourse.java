package com.Revature.Jamaal_Smith_P0_Project.Screens;

import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;

import java.io.BufferedReader;

public class ProfCourse extends Screen{
    public ProfCourse(BufferedReader consoleReader, ScreenRouter router) {
        super("ProfCourse", "/ProfCourse",consoleReader,router);
    }

    @Override
    public void render() throws Exception {
        //This page will be for all actions Professor can take during enrollment
        //Will wait for DB creation to complete



    }
}
