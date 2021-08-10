/** This interface serves as the contract that the course and user repositories must
 * abide by and the functionality that they must possess.
 */

package com.revature.Jamaal_Smith_P0.repos;

import com.revature.Jamaal_Smith_P0.documents.AppUser;

public interface CrudRepository <T> {
    T findById(String T);
     T save(T newResource);
    AppUser update(String updatedResource);
    boolean deleteById(int id);
}
