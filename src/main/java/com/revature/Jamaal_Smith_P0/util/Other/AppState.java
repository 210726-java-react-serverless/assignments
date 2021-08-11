/** This class has the startup and shutdown methods for the applicaiton. Additionally,
 * it possess all of the screens that can be passed through the screenrouter to facilitate
 * the console based user experience.
 */
package com.revature.Jamaal_Smith_P0.util.Other;

import com.revature.Jamaal_Smith_P0.documents.AppUser;
import com.revature.Jamaal_Smith_P0.repos.UserRepository;
import com.revature.Jamaal_Smith_P0.screens.*;
import com.revature.Jamaal_Smith_P0.screens.ProfessorScreens.LoginScreenProf;
import com.revature.Jamaal_Smith_P0.screens.ProfessorScreens.ProfCourseScreen;
import com.revature.Jamaal_Smith_P0.screens.ProfessorScreens.RegisterScreenProf;
import com.revature.Jamaal_Smith_P0.screens.ProfessorScreens.UserSelectionProf;
import com.revature.Jamaal_Smith_P0.screens.StudentScreens.LoginScreenStudent;
import com.revature.Jamaal_Smith_P0.screens.StudentScreens.RegisterScreenStudent;
import com.revature.Jamaal_Smith_P0.screens.StudentScreens.StudentCoursesScreen;
import com.revature.Jamaal_Smith_P0.screens.StudentScreens.UserSelectionStudent;
import com.revature.Jamaal_Smith_P0.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {
    private static boolean appRunning;
    private final ScreenRouter router;


    public AppState() {

        appRunning = true;
        router = new ScreenRouter();
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        UserSession userSession = new UserSession();
        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo, userSession);


        router.addScreen(new WelcomeScreen(consoleReader, router,userService))
                .addScreen(new LoginScreen(consoleReader, router, userService))
                .addScreen(new RegisterScreen(consoleReader, router, userService))
                .addScreen(new DashboardScreen(consoleReader, router, userService))
                .addScreen(new UserProfileScreen(consoleReader, router,userService))
                .addScreen(new ProfCourseScreen(consoleReader,router,userService))
                .addScreen(new StudentCoursesScreen(consoleReader,router,userService))
                .addScreen(new LoginScreenStudent(consoleReader,router,userService))
                .addScreen(new RegisterScreenStudent(consoleReader,router,userService))
                .addScreen(new LoginScreenProf(consoleReader,router,userService))
                .addScreen(new RegisterScreenProf(consoleReader,router,userService))
                .addScreen(new WelcomeScreenReal(consoleReader,router,userService))
                .addScreen(new UserSelectionProf(consoleReader,router,userService))
                .addScreen(new UserSelectionStudent(consoleReader,router,userService));

    }


    /** Allows for the graceful launch of the application.
     *
     */
    public void startup() {
        router.navigate("/welcome");

        while (appRunning) {
            try {
                router.getCurrentScreen().render();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /** Allows for the graceful shutdown of the application.
     */
    public static void shutdown() {
        appRunning = false;
        MongoClientFactory.getInstance().cleanUp();
    }

}


