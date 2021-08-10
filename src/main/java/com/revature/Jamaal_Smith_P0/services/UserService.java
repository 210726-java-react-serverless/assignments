/** This class abstracts many of the methods found in the user repository class.
 *
 */


package com.revature.Jamaal_Smith_P0.services;

import com.revature.Jamaal_Smith_P0.documents.AppUser;
import com.revature.Jamaal_Smith_P0.repos.UserRepository;
import com.revature.Jamaal_Smith_P0.util.Other.UserSession;
import com.revature.Jamaal_Smith_P0.util.exceptions.InvalidRequestException;
import com.revature.Jamaal_Smith_P0.util.exceptions.ResourcePersistenceException;

import javax.security.sasl.AuthenticationException;

public class UserService {
    private final UserRepository userRepo;
    private final UserSession session;


    public UserService(UserRepository userRepo, UserSession session) {
        this.userRepo = userRepo;
        this.session = session;

    }

    /** This method allows for all the getters in the user repository to be accessed.
     *
     * @return
     */
    public UserSession getSession() {
        return session;
    }

    /**Abstraction of the logic needed to register a user in the registry.
     *
     * @param newUser
     * @return
     */
    public AppUser register(AppUser newUser) {

        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }

        if (userRepo.findUserByUsername(newUser.getUsername()) != null) {
            throw new ResourcePersistenceException("Provided username is already taken!");
        }

        if (userRepo.findUserByEmail(newUser.getEmail()) != null) {
            throw new ResourcePersistenceException("Provided username is already taken!");
        }

        return userRepo.save(newUser);

    }

    /** Abstraction of all logic required to login to the application.
     *
     * @param username
     * @param password
     * @return
     * @throws AuthenticationException
     */
    public AppUser login(String username, String password) throws AuthenticationException {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid user credentials provided!");
        }

        AppUser authUser = userRepo.findUserByCredentials(username, password);

        if (authUser == null) {
            throw new AuthenticationException("Invalid credentials provided!");
        }

        session.setCurrentUser(authUser);

        return authUser;

    }

    /** Boolean test to make sure that inputs received via I/O to be verified and part of the logic
     * utilized to assist with the registration of users.
     * @param user
     * @return
     */
    public boolean isUserValid(AppUser user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        return user.getPassword() != null && !user.getPassword().trim().equals("");
    }
    public AppUser updateUser (AppUser user, AppUser newUser){
        AppUser updateUser = userRepo.update(user,newUser);
        return updateUser;
    }

}

