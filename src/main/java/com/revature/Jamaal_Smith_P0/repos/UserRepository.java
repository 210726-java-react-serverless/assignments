/** The user repository contains all the methods that can be applied to professors and students
 * in the enrollment system.
 */

package com.revature.Jamaal_Smith_P0.repos;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.revature.Jamaal_Smith_P0.documents.AppUser;
import com.revature.Jamaal_Smith_P0.util.Other.MongoClientFactory;
import com.revature.Jamaal_Smith_P0.util.exceptions.DataSourceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;


public class UserRepository implements CrudRepository <AppUser> {
        private final Logger logger = LogManager.getLogger(UserRepository.class);

        /** This method allows for an individual to be located when their username and password
         * are provided as parameters.
          * @param username
         * @param password
         * @return
         */
        public AppUser findUserByCredentials(String username, String password) {

                try {
                        MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
                        MongoDatabase userDatabase = mongoClient.getDatabase("project0");
                        MongoCollection<Document> usersCollection = userDatabase.getCollection("users");
                        Document queryDoc = new Document("username", username).append("password", password);
                        Document authUserDoc = usersCollection.find(queryDoc).first();

                        if (authUserDoc == null) {
                                return null;
                        }

                        ObjectMapper mapper = new ObjectMapper();
                        AppUser authUser = mapper.readValue(authUserDoc.toJson(), AppUser.class);
                        authUser.setId(authUserDoc.get("_id").toString());
                        return authUser;

                } catch (JsonMappingException jme) {
                        logger.error("An exception occurred while mapping the document.", jme);
                        throw new DataSourceException("An exception occurred while mapping the document.", jme);
                } catch (Exception e) {
                        logger.error("An unexpected exception occurred.", e);
                        throw new DataSourceException("An unexpected exception occurred.", e);
                }
        }

        /** This method allows for a user to be located when their username is provided as a parameter.
         *
         * @param username
         * @return
         */
        public AppUser findUserByUsername(String username) {
                try {
                        MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
                        MongoDatabase userDatabase = mongoClient.getDatabase("project0");
                        MongoCollection<Document> usersCollection = userDatabase.getCollection("users");
                        Document queryDoc = new Document("username", username);
                        Document authUserDoc = usersCollection.find(queryDoc).first();

                        if (authUserDoc == null) {
                                return null;
                        }

                        ObjectMapper mapper = new ObjectMapper();
                        AppUser authUser = mapper.readValue(authUserDoc.toJson(), AppUser.class);
                        authUser.setId(authUserDoc.get("_id").toString());
                        return authUser;

                } catch (JsonMappingException jme) {
                        logger.error("An exception occurred while mapping the document.", jme);
                        throw new DataSourceException("An exception occurred while mapping the document.", jme);
                } catch (Exception e) {
                        logger.error("An unexpected exception occurred.", e);
                        throw new DataSourceException("An unexpected exception occurred.", e);
                }
        }

        /** This method allows for a user to be located when their email is provided as a parameter.
         *
         * @param email
         * @return
         */
        public AppUser findUserByEmail(String email) {
                try {
                        MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
                        MongoDatabase userDatabase = mongoClient.getDatabase("project0");
                        MongoCollection<Document> usersCollection = userDatabase.getCollection("users");
                        Document queryDoc = new Document("email", email);
                        Document authUserDoc = usersCollection.find(queryDoc).first();

                        if (authUserDoc == null) {
                                return null;
                        }

                        ObjectMapper mapper = new ObjectMapper();
                        AppUser authUser = mapper.readValue(authUserDoc.toJson(), AppUser.class);
                        authUser.setId(authUserDoc.get("_id").toString());
                        return authUser;

                } catch (JsonMappingException jme) {
                        logger.error("An exception occurred while mapping the document.", jme);
                        throw new DataSourceException("An exception occurred while mapping the document.", jme);
                } catch (Exception e) {
                        logger.error("An unexpected exception occurred.", e);
                        throw new DataSourceException("An unexpected exception occurred.", e);
                }
        }


        @Override
        public AppUser findById(String courseNumber) {
                return null;
        }

        /** The save method is key to assisting with the registration of users on the registration
         * screen and enables these details to be saved on the database.
         * @param newUser
         * @return
         */
        public AppUser save(AppUser newUser) {
                try {
                        MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
                        MongoDatabase userDb = mongoClient.getDatabase("project0");
                        MongoCollection<Document> usersCollection = userDb.getCollection("users");
                        Document newUserDoc = new Document("firstName", newUser.getFirstName())
                                .append("lastName", newUser.getLastName())
                                .append("email", newUser.getEmail())
                                .append("username", newUser.getUsername())
                                .append("password", newUser.getPassword()).append("role", newUser.getRole());

                        usersCollection.insertOne(newUserDoc);
                        newUser.setId(newUserDoc.get("_id").toString());

                        return newUser;

                } catch (Exception e) {
                        logger.error("An unexpected exception occurred.", e);
                        throw new DataSourceException("An unexpected exception occurred.", e);
                }
        }

        public AppUser update(AppUser updatedResource) {
                return null;
        }


        @Override
        public boolean deleteById(int id) {
                return false;
        }

        /** The update method enables an existing user to alter any fields in their document.
         *
         * @param user
         * @param updatedResource
         * @return
         */
        public AppUser update(AppUser user, AppUser updatedResource) {
                MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
                MongoDatabase userDb = mongoClient.getDatabase("project0");
                MongoCollection<Document> usersCollection = userDb.getCollection("users");
                usersCollection.updateOne(Filters.eq("id", updatedResource.getId()), Updates.combine(
                        Updates.set("firstName", updatedResource.getFirstName()), Updates.set("lastName", updatedResource.getLastName()),
                        Updates.set("email", updatedResource.getEmail()), Updates.set("username", updatedResource.getUsername()),
                        Updates.set("password", updatedResource.getPassword()), Updates.set("role", updatedResource.getRole())));

                return updatedResource;
        }

        /** The removeUser method allows for a user to delete themselves from the database.
         *
         * @param username
         * @return
         */
        public AppUser removeUser(String username) {
                try {
                        MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
                        MongoDatabase courseDatabase = mongoClient.getDatabase("project0");
                        MongoCollection<Document> usersCollection = courseDatabase.getCollection("users");
                        Document queryDoc = new Document("username", username);
                        Document removalItem = usersCollection.find(queryDoc).first();

                        if (removalItem == null) {
                                return null;
                        }

                        usersCollection.deleteOne(removalItem);

                } catch (Exception e) {
                        logger.error("An unexpected exception occurred.", e);
                }
                return null;

                }

        public boolean deleteById(String id){
                return false;
                }
        }

