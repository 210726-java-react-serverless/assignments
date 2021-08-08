package com.revature.Jamaal_Smith_P0.screens;

import com.revature.Jamaal_Smith_P0.documents.AppUser;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.io.BufferedReader;

public class UserProfileScreen extends Screen {
    private UserService service;

    public UserProfileScreen(BufferedReader consoleReader, ScreenRouter router, UserService service) {
        super("UserProfileScreen", "/profile", consoleReader, router);
        this.service = service;
    }

    /*
        TODO
         Implement a profile screen that displays that can be used to display and update
         user profile information.
     */
    @Override
    public void render() {
        System.out.println(service.getSession().getCurrentUser().getUsername());
        System.out.println(service.getSession().getCurrentUser().getEmail());




}
}

