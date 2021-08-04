package com.Revature.Jamaal_Smith_P0_Project.Routers;

import com.Revature.Jamaal_Smith_P0_Project.Screens.*;
import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {
    public boolean appRunning;
    private final ScreenRouter router;
    private final Logger logger = LogManager.getLogger(AppState.class);


    public AppState() {
        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        router.addScreen(new LogIn(consoleReader, router));
        router.addScreen(new ProfDecisions(consoleReader, router));
        router.addScreen(new ProfCourse(consoleReader, router));
        router.addScreen(new Home(consoleReader, router));
        router.addScreen(new StudentDecisions(consoleReader, router));
        router.addScreen(new Registration(consoleReader, router));
        router.addScreen(new StudentDecisions(consoleReader, router));
        router.addScreen(new Summary_Checkout(consoleReader, router));
    }


    public void startup() {
        router.navigate("/UserType");

        while (appRunning) {
            try {
                router.getCurrentScreen().render();
            } catch (Exception e) {
                logger.info("User Type information not received");
                logger.error(e.printStackTrace());


            }
        }
    }
}






















