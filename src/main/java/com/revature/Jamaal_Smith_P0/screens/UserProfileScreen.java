package com.revature.Jamaal_Smith_P0.screens;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;
import com.revature.Jamaal_Smith_P0.documents.AppUser;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;


public class UserProfileScreen extends Screen {
    private UserService service;
    private final Logger logger = LogManager.getLogger(UserProfileScreen.class);

    public UserProfileScreen(BufferedReader consoleReader, ScreenRouter router, UserService service) {
        super("UserProfileScreen", "/profile", consoleReader, router);
        this.service = service;
    }


    @Override
    public void render() {
        System.out.println("Welcome To Your User Profile\n");


        System.out.println("\nCurrent Username: " + service.getSession().getCurrentUser().getUsername());
        System.out.println("Current Email: " + service.getSession().getCurrentUser().getEmail());
        System.out.println("Current First Name: " + service.getSession().getCurrentUser().getFirstName());
        System.out.println("Current Last Name: " + service.getSession().getCurrentUser().getLastName());

        System.out.println("\n If these details are the most current, feel free to review the course catalog");

        System.out.println("1 - Everything looks good, take me to the courses");
        System.out.println("2 - I would like to update some fields");

        try {
            String userInput = consoleReader.readLine();
            String userRole = service.getSession().getCurrentUser().getRole();

            if (userInput == "1" && userRole == "student") {
                router.navigate("/studentCourses");
            }
            if (userInput == "1" && userRole == "professor") {
                router.navigate("/profcourses");
            }
            if (userInput == "2" && userRole == "student") {
                router.navigate("/studentUpdate");
            }
            if (userInput == "2" && userRole == "professor") {
                router.navigate("/professorUpdate");
            } else {
                System.out.println("Input received not recognized");
            }
        }catch (IOException ioe){logger.error(ioe);

        }




}
}

