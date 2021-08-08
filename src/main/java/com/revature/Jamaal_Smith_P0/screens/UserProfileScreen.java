package com.revature.Jamaal_Smith_P0.screens;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;
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
        System.out.println("Welcome To Your User Profile\n");
        System.out.printf("We see that you are a %n at RevaU",service.getSession().getCurrentUser().getRole());

        System.out.println("Current Username: " + service.getSession().getCurrentUser().getUsername());
        System.out.println("Current Email: " + service.getSession().getCurrentUser().getEmail());
        System.out.println("Current First Name: " + service.getSession().getCurrentUser().getFirstName());
        System.out.println("Current Last Name: \n" + service.getSession().getCurrentUser().getLastName());

        System.out.println("If these details are the most current, feel free to review the course catalog/n");

        router.navigate;




}
}

