package com.Revature.Jamaal_Smith_P0_Project.Services;

import com.Revature.Jamaal_Smith_P0_Project.Screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Screen currentScreen;
    private Set<Screen> screens = new HashSet<>();

    public ScreenRouter addScreen (Screen screen){
        screens.add(screen);
        return this;
    }

    public void navigate(String route) {
        for (Screen screen : screens) {
            if (screen.getRoute().equals(route)) {
                currentScreen = screen;
                break;

            }
        }
    }

    public Screen getCurrentScreen() {
        return currentScreen;
    }
}
