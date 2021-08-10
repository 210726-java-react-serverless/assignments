/** This class enables one to access details about the user currently logged into the
 * system.
 */
package com.revature.Jamaal_Smith_P0.util.Other;

import com.revature.Jamaal_Smith_P0.documents.AppUser;

public class UserSession {
    private AppUser currentUser;


    public AppUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(AppUser currentUser) {
        this.currentUser = currentUser;
    }

    public boolean isActive() {
        return currentUser != null;
    }

    public void closeSession() {
        setCurrentUser(null);
    }


    }
