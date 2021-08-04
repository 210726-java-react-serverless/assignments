package com.Revature.Jamaal_Smith_P0_Project.Screens;

import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserType extends Screen{

    public UserType(BufferedReader consoleReader, ScreenRouter router) {
        super("UserType","/UserType",consoleReader,router);
    }

    @Override
    public void render() throws IOException {
        String ConsoleText = "Welcome to RevRoll. Please select one of the following: /n" +
                             "1 - This is my first time using RevRoll /n" +
                             "2 -  I am a returning RevRoll user /n";

        System.out.println(ConsoleText);

        //getting user inputs
        //BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = consoleReader.readLine();

        //display user input
        System.out.println(userInput);
    }
}
