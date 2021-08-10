/** This screen is where returning application users can come to create usernames and passwords
 * to gain access into the registration system.
 */


package com.revature.Jamaal_Smith_P0.screens;

import com.revature.Jamaal_Smith_P0.documents.AppUser;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.conversions.Bson;

import java.io.BufferedReader;

public class RegisterScreen extends Screen {
    private final Logger logger = LogManager.getLogger(RegisterScreen.class);
    private final UserService userService;
    public Bson username;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("RegisterScreen", "/register", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {

        System.out.println("\nUser Registration\n" +
                "1) Register\n" +
                "2) Go Back\n");
        System.out.println("> ");

        int userChoice = 0;
        try {
            userChoice = Integer.parseInt(consoleReader.readLine());
        } catch(Exception e) {
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

        System.out.println("\nRegister for a new account!");

        System.out.print("First name: ");
        String firstName = consoleReader.readLine();

        System.out.print("Last name: ");
        String lastName = consoleReader.readLine();

        System.out.print("Email: ");
        String email = consoleReader.readLine();

        System.out.print("Username: ");
        String username = consoleReader.readLine();

        System.out.print("Password: ");
        String password = consoleReader.readLine();

        System.out.println("Role (student or professor)");
        String role = consoleReader.readLine();

        AppUser newUser = new AppUser(firstName, lastName, email, username, password, role);
        System.out.println(newUser);
        try {
            userService.register(newUser);
            logger.info("User successfully registered!");
            router.navigate("/dashboard");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.debug("User not registered!");
            router.navigate("/welcome");
        }

    }

}

