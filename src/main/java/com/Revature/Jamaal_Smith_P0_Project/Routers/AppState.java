package com.Revature.Jamaal_Smith_P0_Project.Routers;

import com.Revature.Jamaal_Smith_P0_Project.Screens.*;
import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {
    public boolean appRunning;
    private final ScreenRouter router;

    public AppState() {
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        router.addScreen(new LogIn(consoleReader, router));
        router.addScreen(new ProfDecisions(consoleReader, router));
        router.addScreen(new ProfCourse(consoleReader, router));
        router.addScreen(new Home(consoleReader, router));
        router.addScreen(new StudentDecisions(consoleReader, router));
        router.addScreen(new StudentCourse(consoleReader, router));
        router.addScreen(new StudentDecisions(consoleReader, router));
        router.addScreen(new Summary_Checkout(consoleReader, router));
        router.addScreen(new UserType(consoleReader, router));


    }


    public void startUp() {
        router.navigate("/Home");
        int counter = 0;
        while (counter < 1) {
            try {
                router.getCurrentScreen().render();
                counter ++;
            } catch (Exception e) {
                e.printStackTrace();


            }
        }
    }
}





















