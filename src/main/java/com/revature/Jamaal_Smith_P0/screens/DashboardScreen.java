package com.revature.Jamaal_Smith_P0.screens;

import com.revature.Jamaal_Smith_P0.documents.AppUser;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.AppState;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;

public class DashboardScreen extends Screen {
    private final UserService userService;
    private AppState app;
    private final Logger logger = LogManager.getLogger(DashboardScreen.class);

    public DashboardScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("DashboardScreen", "/dashboard", consoleReader, router);
        this.userService = userService;
        this.app = app;
    }

    /*
         them the option
         to navigate to other screens (e.g. UserProfileScreen).
     */
    @Override
    public void render() throws Exception {


        if (!userService.getSession().isActive()) {
            System.out.println("Session invalidated, navigating back to welcome screen...");
            router.navigate("/welcome");
            return;
        }

        AppUser currentUser = userService.getSession().getCurrentUser();
        //display options for the Dashboard
        System.out.println("Welcome to your dashboard, " + currentUser.getUsername());

        System. out. println("Please select what you would like to do today:\n");

        System.out.println("1 - Review and update your profile information");

        System.out.println("2 - Review available courses for enrollment");

        System.out.println("3 - Exit RevaRoll");

        //selection logic
        String userSelection = consoleReader.readLine();

        switch (userSelection){

            case "1": router.navigate("/profile");
                    break;

            case "2": router.navigate("/courses");
                    break;

            case "3": app.shutdown();
            break;
        }



    }

}
