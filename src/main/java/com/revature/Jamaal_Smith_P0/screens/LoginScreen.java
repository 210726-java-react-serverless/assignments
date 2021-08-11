/** The log in screen is where new application users will enter their username and password to
 * gain entry into the system. Implementation of the previous screen was borrowed from training
 * activities where batch members designed its implementation.
 */


package com.revature.Jamaal_Smith_P0.screens;

import com.revature.Jamaal_Smith_P0.documents.AppUser;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;

public class LoginScreen extends Screen {

    private final UserService userService;
    private AppUser authUser;
    private final Logger logger = LogManager.getLogger(RegisterScreen.class);

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("LoginScreen", "/login", consoleReader, router);
        this.userService = userService;
        this.authUser = authUser;

    }

    @Override
    public void render() throws Exception {

        System.out.println("\nUser Login\n" +
                "1) Login\n" +
                "2) Go Back\n");
        System.out.print("> ");

        int userChoice = 0;
        try {
            userChoice = Integer.parseInt(consoleReader.readLine());
        } catch (Exception e) {
            //User choice will still be 0 and will hit default below
            logger.error("Non-numeric string entered by user");
        }

        switch (userChoice) {
            case 1:
                break;
            case 2:
                router.goToPrevious();
                return;
            default:
                System.out.println("Invalid entry");
                return;
        }

        System.out.print("Username: ");
        String username = consoleReader.readLine();

        System.out.print("Password: ");
        String password = consoleReader.readLine();


        try {
            authUser = userService.login(username, password);
            System.out.println("Login successful!\n");

            if (authUser.getRole().equalsIgnoreCase("student")) {
                router.navigate("/studentCourses");
            }

            if (authUser.getRole().equalsIgnoreCase("professor")) {
                router.navigate("/profCourses");
            }


        } catch (Exception ae) {
            System.out.println("No user found with provided credentials!");
            System.out.println("Navigating back to welcome screen...");
            router.navigate("/welcome");
        }



    }

}


