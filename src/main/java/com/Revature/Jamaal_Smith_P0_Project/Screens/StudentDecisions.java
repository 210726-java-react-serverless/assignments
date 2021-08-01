package com.Revature.Jamaal_Smith_P0_Project.Screens;

import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StudentDecisions extends Screen{
    public StudentDecisions(BufferedReader consoleReader, ScreenRouter router) {

        super("StudentDecisions", "/StudentDecisions",consoleReader,router);
    }

    @Override
    public void render() throws Exception {
        String ConsoleText = "How can we assist you today:/n" +
                "1 - View available courses /n" +
                "2 - Enroll in courses /n" +
                "3 - Amend course selections";

        System.out.println(ConsoleText);

        //getting user inputs
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = consoleReader.readLine();

        //display user input
        System.out.println(userInput);

    }




    }

