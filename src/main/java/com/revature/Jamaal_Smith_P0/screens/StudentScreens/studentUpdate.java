package com.revature.Jamaal_Smith_P0.screens.StudentScreens;

import com.revature.Jamaal_Smith_P0.screens.Screen;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;

import java.io.BufferedReader;

//this screen will allow Student to update their information

public class studentUpdate extends Screen {
    private UserService userService;

    public studentUpdate(String name, String route, BufferedReader consoleReader, ScreenRouter router,
                         UserService userService) {
        super("studentUpdate", "/studentUpdate", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {

    }
}
