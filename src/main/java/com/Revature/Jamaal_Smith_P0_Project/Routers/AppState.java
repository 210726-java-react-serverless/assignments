package com.Revature.Jamaal_Smith_P0_Project.Routers;

import com.Revature.Jamaal_Smith_P0_Project.Screens.RoleDesignationScreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppState {
    //Created two objects so pages can be loaded below
    StudentFlow studentFlow = new StudentFlow();
    ProfFlow profFlow = new ProfFlow();

    // Goal of block: get the input from the RoleDesignationScreen to trigger the Student or Prof flow
    public void appStart() throws IOException {

        //Starts the app execution
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        RoleDesignationScreen firstPage = new RoleDesignationScreen();
        firstPage.render();


        //if( == "1"){
           // studentFlow.render();
       // }else{profFlow.render();}

            //Collect role of user
            // if (consoleReader.readLine() != 1) {
            // profFlow.render();
            // } else {
            //   studentFlow.render();
        }

    }
}










