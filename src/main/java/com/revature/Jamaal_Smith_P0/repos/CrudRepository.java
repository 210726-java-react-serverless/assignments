package com.revature.Jamaal_Smith_P0.repos;

import com.revature.Jamaal_Smith_P0.documents.AppUser;

public interface CrudRepository <T> {
    T findById(String courseNumber);

     T save(T newResource);
    AppUser update(String updatedResource);
    boolean deleteById(int id);
}
