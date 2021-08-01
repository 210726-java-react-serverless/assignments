package com.Revature.Jamaal_Smith_P0_Project.Screens;

import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogIn extends Screen{


    public LogIn(BufferedReader consoleReader, ScreenRouter router) {

        super("LogIn", "/LogIn",consoleReader,router);
    }

    @Override
    public void render() throws IOException {
        // Token will be created by performing math operation on each hashcode store in DB
        String ConsoleText = " Please provide your personal access tokens below: /n" +
                               "Token: /n" +
                                "<";
        System.out.println(ConsoleText);

        //getting user inputs
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = consoleReader.readLine();

        //display user input
        System.out.println(userInput);
    }
}
