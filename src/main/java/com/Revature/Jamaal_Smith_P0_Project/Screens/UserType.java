package com.Revature.Jamaal_Smith_P0_Project.Screens;

import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;


public class UserType extends Screen{
    public UserType(){
        super("UserType","/UserType");
    }




    @Override
    public void render()  {
        String ConsoleText = "Welcome to RevRoll. Please select one of the following: /n" +
                             "1 - This is my first time using RevRoll /n" +
                             "2 -  I am a returning RevRoll user /n";


        System.out.println(ConsoleText);

        String userInput = null;
        try {
            userInput = consoleReader.readLine();
        } catch (IOException e) {
            logger.info("User type not detected");
        }


        if(userInput == "1"){
            router.navigate("/Registration");
        } else {
            router.navigate("/Login");
        }


    }

    private final Logger logger = LogManager.getLogger(UserType.class);
}
