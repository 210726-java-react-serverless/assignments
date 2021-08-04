package com.Revature.Jamaal_Smith_P0_Project.Screens;

import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;

import java.io.BufferedReader;

public class Registration extends Screen{
    public Registration(BufferedReader consoleReader, ScreenRouter router) {
        super("Registration", "/Registration", consoleReader,router);
    }

    @Override
    public void render() throws Exception {
        //This screen will show all course data and enable student to make selections.
        //Will populate fully after Database is created
    }
}
