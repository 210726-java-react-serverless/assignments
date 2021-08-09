package com.revature.Jamaal_Smith_P0.repos;

public interface CrudRepository <J> {
    J findById(String courseNumber);

    default J save(J newResource) {
        return null;
    }

    boolean update(J updatedResource);
    boolean deleteById(int id);
}
