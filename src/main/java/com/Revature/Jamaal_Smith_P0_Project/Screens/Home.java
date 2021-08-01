package com.Revature.Jamaal_Smith_P0_Project.Screens;

import com.Revature.Jamaal_Smith_P0_Project.Routers.AppState;
import com.Revature.Jamaal_Smith_P0_Project.Routers.ProfFlow;
import com.Revature.Jamaal_Smith_P0_Project.Routers.StudentFlow;
import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Home extends Screen {

    public Home(BufferedReader consoleReader, ScreenRouter router) {
        super("Home", "/Home", consoleReader, router);

    }


    public void render() throws IOException {
        String consoleText = " Please select your relationship to the University:\n" +
                "\n1 - Student \n" +
                "\n2 - Professor \n";

        System.out.println(consoleText);

        String userSelection = consoleReader.readLine();

        switch (userSelection){
            case "1":
                StudentFlow studentFlow = new StudentFlow();
                studentFlow.render();
                break;

            case "2":
                ProfFlow profFlow = new ProfFlow();
                profFlow.render();

                break;

            default:
                System.out.print("Please select either Student or Professor");
        }
    }
}

