package com.revature.Jamaal_Smith_P0.repos;

public interface CrudRepository <T> {
    T findById(String courseNumber);

     T save(T newResource);
    boolean update(T updatedResource);
    boolean deleteById(int id);
}
