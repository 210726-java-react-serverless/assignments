package com.Revature.Jamaal_Smith_P0_Project.Screens;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProfDecisions extends Screen{
    public ProfDecisions(String name, String route) {
        super("ProfDecisions", "/ProfDecisions");
    }

    @Override
    public void render() throws Exception{
        String ConsoleText = "How can we assist you today:/n" +
                "1 - View available courses /n" +
                "2 - Add available courses /n" +
                "3 - Delete course(s)";

        System.out.print(ConsoleText);

        //getting user inputs
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = consoleReader.readLine();

        //display user input
        System.out.println(userInput);
    }
}
