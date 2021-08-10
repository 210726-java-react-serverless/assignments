/** This screen enables a professor with the ability to update their credentials.
 *
 */
package com.revature.Jamaal_Smith_P0.screens.ProfessorScreens;

import com.revature.Jamaal_Smith_P0.documents.AppUser;
import com.revature.Jamaal_Smith_P0.repos.UserRepository;
import com.revature.Jamaal_Smith_P0.screens.Screen;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.ScreenRouter;

import java.io.BufferedReader;

public class professorUpdate extends Screen {
    private UserService userService;
    private AppUser appUser;
    private UserRepository userRepo;

    // this screen will allow for the professor to update their information

    public professorUpdate(String name, String route, BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("professorUpdate","/professorUpdate", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {
        System.out.println(userService.getSession().getCurrentUser() + ",Lets update your profile");

        System.out.println("id");
        String id = consoleReader.readLine();

        System.out.println("First Name:");
        String firstName = consoleReader.readLine();

        System.out.println("Last Name:");
        String lastName = consoleReader.readLine();

        System.out.println("Email:");
        String email = consoleReader.readLine();

        System.out.println("Password");
        String password = consoleReader.readLine();

        System.out.println("role");
        String role = consoleReader.readLine();


        AppUser updatedResourse = new AppUser(id,firstName,lastName,email,password,role);
        userRepo.update(updatedResourse);

        router.navigate("/profCourses");



    }
}
