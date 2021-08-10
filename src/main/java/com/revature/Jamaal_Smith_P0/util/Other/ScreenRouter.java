/** This class contains all the logic that controls how screens are accessed while the
 * application is running.
 */

package com.revature.Jamaal_Smith_P0.util.Other;

import com.revature.Jamaal_Smith_P0.screens.Screen;
import com.revature.Jamaal_Smith_P0.util.exceptions.ScreenNotFoundException;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {
    private Screen currentScreen;
    private final Set<Screen> screens = new HashSet<>();
    private ArrayDeque<Screen> history;

    public ScreenRouter() {
        history = new ArrayDeque<Screen>();
    }

    /** Method that enables screens to be loaded into the router so that they can be
     * accessed with their route.
     * @param screen
     * @return
     */
    public ScreenRouter addScreen(Screen screen) {
        screens.add(screen);
        return this;
    }

    /** Method that can be used to go to different screens in the application.
     *
     * @param route
     */
    public void navigate(String route) {
        if(currentScreen != null) {
            history.push(currentScreen);
        }
        currentScreen = screens.stream()
                .filter(screen -> screen.getRoute().equals(route))
                .findFirst()
                .orElseThrow(ScreenNotFoundException::new);
    }

    /** Logic that enables the user to return to their previous screen.
     *
     * @throws ScreenNotFoundException
     */
    public void goToPrevious() throws ScreenNotFoundException{
        if (history.size() == 0) { throw new ScreenNotFoundException(); }
        currentScreen = history.pop();
    }

    /** This method gets the details about the current screen that the user is currently viewing.
     *
     * @return
     */
    public Screen getCurrentScreen() {
        return currentScreen;
    }

    public int historySize() {
        return history.size();
    }

    public boolean hasHistory() {
        return history.size() > 0;
    }

    public void clearHistory() {
        history.clear();
    }
}
