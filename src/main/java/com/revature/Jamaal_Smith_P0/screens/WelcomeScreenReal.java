package com.revature.Jamaal_Smith_P0.screens;

import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;

import java.io.BufferedReader;

public class WelcomeScreenReal extends Screen {

    private final UserService userService;


    public WelcomeScreenReal(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("welcomeScreenreal", "/welcomeReal", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {

        System.out.println("Welcome to RevaRoll!\n");
        System.out.println("Please select your role:\n");

        System.out.println("1 - Student");
        System.out.println("2 - Professor");

        String userSelection = consoleReader.readLine();

        if (userSelection == "1") {
            router.navigate("/userSelectionStudent");
        }
        if (userSelection == "2") {
            router.navigate("/userSelectionProf");
        } else {
            router.navigate("/welcomeScreenReal");
        }
    }
}
