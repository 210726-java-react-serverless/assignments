package com.Revature.Jamaal_Smith_P0_Project.Screens;

import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;

import java.io.BufferedReader;

public class Summary_Checkout extends Screen{
    public Summary_Checkout(BufferedReader consoleReader, ScreenRouter router) {

        super("Summary_Checkout", "/Summary_Checkout",consoleReader,router);
    }

    @Override
    public void render() throws Exception {
        //Will populate based on DB creation
        //Page will have to show all the actions that the PPT took during their session
    }
}
