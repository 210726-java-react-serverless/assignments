package com.Revature.Jamaal_Smith_P0_Project;

import com.Revature.Jamaal_Smith_P0_Project.Routers.AppState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class app {

    //private final Logger logger = LogManager.getLogger(app.class);
    public static void main(String[] args) {

        AppState app = new AppState();
        app.startup();
    }
}



