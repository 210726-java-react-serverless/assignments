package com.Revature.Jamaal_Smith_P0_Project.Screens;

import com.Revature.Jamaal_Smith_P0_Project.Routers.AppState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoleDesignationScreen extends Screen{

    public RoleDesignationScreen(BufferedReader consoleReader) {
        super("RoleDesignationScreen", "/RoleDesignationScreen",consoleReader);

        }

    public RoleDesignationScreen() {
        super("RoleDesignationScreen", "/RoleDesignationScreen");
    }


    public void render() throws IOException {
        String ConsoleText = " Please select your relationship to the University:\n" +
                "\n1 - Student \n" +
                "\n2 - Professor \n";

        System.out.println(ConsoleText);

        //getting user inputs
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = consoleReader.readLine();

        AppState appState = new AppState();
        appState.appStart();

        System.out.println(userInput);

    }
}

