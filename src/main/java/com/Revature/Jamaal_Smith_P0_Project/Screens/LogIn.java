package com.Revature.Jamaal_Smith_P0_Project.Screens;

import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogIn extends Screen{

    private final Logger logger = LogManager.getLogger(LogIn.class);


    public LogIn(BufferedReader consoleReader, ScreenRouter router) {

        super("LogIn", "/LogIn",consoleReader,router);
    }

    @Override
    public void render()  {
        System.out.println("Welcome to the Registration System");

        System.out.println("Please enter your username:");
        try {
            String username = consoleReader.readLine();
        } catch (IOException e) {
            logger.info("username entered incorrectly");
            e.printStackTrace();
        }

        System.out.println("Please enter your password:");
        try {
            String password = consoleReader.readLine();
        } catch (IOException e) {
            logger.info("Password entered incorrectly");
            e.printStackTrace();
        }


    }
}
