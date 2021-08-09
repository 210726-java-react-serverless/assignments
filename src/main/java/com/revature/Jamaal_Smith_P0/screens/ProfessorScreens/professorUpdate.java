package com.revature.Jamaal_Smith_P0.screens.ProfessorScreens;

import com.revature.Jamaal_Smith_P0.screens.Screen;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;

import java.io.BufferedReader;

public class professorUpdate extends Screen {
    private UserService userService;

    // this screen will allow for the professor to update their information

    public professorUpdate(String name, String route, BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("professorUpdate","/professorUpdate", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {

    }
}
