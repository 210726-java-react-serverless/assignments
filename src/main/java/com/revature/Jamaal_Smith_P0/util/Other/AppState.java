package com.revature.Jamaal_Smith_P0.util.Other;

import com.revature.Jamaal_Smith_P0.documents.AppUser;
import com.revature.Jamaal_Smith_P0.repos.UserRepository;
import com.revature.Jamaal_Smith_P0.screens.*;
import com.revature.Jamaal_Smith_P0.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {
    private static boolean appRunning;
    private final ScreenRouter router;
    private AppUser user;

    public AppState() {

        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        UserSession userSession = new UserSession();
        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo, userSession);


        router.addScreen(new WelcomeScreen(consoleReader, router,userService))
                .addScreen(new LoginScreen(consoleReader, router, userService))
                .addScreen(new RegisterScreen(consoleReader, router, userService))
                .addScreen(new DashboardScreen(consoleReader, router, userService))
                .addScreen(new UserProfileScreen(consoleReader, router,userService))
                .addScreen(new ProfCoursesScreen(consoleReader,router,userService))
                .addScreen(new StudentCoursesScreen(consoleReader,router,userService));

    }



    public void startup() {
        router.navigate("/welcome");

        while (appRunning) {
            try {
                router.getCurrentScreen().render();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Switches 'appRunning' to false, ending the while loop and
    // closing the app through super's main.
    public static void shutdown() {
        appRunning = false;
        MongoClientFactory.getInstance().cleanUp();
    }

}


