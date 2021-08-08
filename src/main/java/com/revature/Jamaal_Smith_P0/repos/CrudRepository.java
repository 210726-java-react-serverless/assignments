package com.revature.Jamaal_Smith_P0.repos;

public interface CrudRepository <J> {
    J findById(int id);
    J save(J newResource);
    boolean update(J updatedResource);
    boolean deleteById(int id);
}
