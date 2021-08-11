package com.revature.Jamaal_Smith_P0.screens.ProfessorScreens;

import com.revature.Jamaal_Smith_P0.screens.Screen;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;

import java.io.BufferedReader;

public class UserSelectionProf extends Screen {

    private final UserService userService;

    public UserSelectionProf(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("userSelectionProf", "/userSelectionProf", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {
        System.out.println("What would you like to do?\n");
        System.out.println("1 - Login");
        System.out.println("2 - Register");

        String userSelection = consoleReader.readLine();

        if (userSelection == "1") {
            router.navigate("/loginProf");
        } else {
            router.navigate("/registerProf");


        }
    }
}
