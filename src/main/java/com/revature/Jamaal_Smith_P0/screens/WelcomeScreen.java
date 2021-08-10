/** This is the first screen that appears once the application is initiated.
 *
 */


package com.revature.Jamaal_Smith_P0.screens;

import com.revature.Jamaal_Smith_P0.documents.AppUser;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;

import java.io.BufferedReader;

import static com.revature.Jamaal_Smith_P0.util.Other.AppState.shutdown;

public class WelcomeScreen extends Screen {
    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router, UserService user)
    { super("WelcomeScreen", "/welcome", consoleReader, router); }

    @Override
    public void render() throws Exception {

        String menu = "\nWelcome to RevaRoll!\n" +
                "1) Login\n" +
                "2) Register\n" +
                "3) Exit application\n" +
                "> ";

        System.out.print(menu);

        String userSelection = consoleReader.readLine();

        switch (userSelection) {

            case "1":
                router.navigate("/login");
                break;
            case "2":
                router.navigate("/register");
                break;
            case "3":
                System.out.println("Exiting application...");
                shutdown();
                break;
            default:
                System.out.println("You provided an invalid value, please try again.");

        }

    }

}

