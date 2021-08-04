package com.Revature.Jamaal_Smith_P0_Project.Services;

import com.Revature.Jamaal_Smith_P0_Project.Screens.Screen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private final Logger logger = LogManager.getLogger(ScreenRouter.class);
    private Screen currentScreen;
    private Set<Screen> screens = new HashSet<>();

    public ScreenRouter addScreen (Screen screen){
        screens.add(screen);
        return this;
    }

    public void navigate(String route) {
        for (Screen screen : screens) {
            if (screen.getRoute().equals(route)) {
                logger.info("Screen selection completed successfully");
                currentScreen = screen;
                break;
            }logger.info("Screen selection not completed");
        }
    }

    public Screen getCurrentScreen() {
        return currentScreen;
    }
}
