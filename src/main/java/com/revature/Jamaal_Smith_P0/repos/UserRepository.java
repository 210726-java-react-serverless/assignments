package com.revature.Jamaal_Smith_P0.repos;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.revature.Jamaal_Smith_P0.documents.AppUser;
import com.revature.Jamaal_Smith_P0.util.Other.MongoClientFactory;
import com.revature.Jamaal_Smith_P0.util.exceptions.DataSourceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;


public class UserRepository implements CrudRepository <AppUser> {
private final Logger logger = LogManager.getLogger(UserRepository.class);



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

        public AppUser findById(int id) {
        return null;
        }


        public AppUser save(AppUser newUser) {
        try {
        MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();

        MongoDatabase userDb = mongoClient.getDatabase("project0");
        MongoCollection<Document> usersCollection = userDb.getCollection("users");
        Document newUserDoc = new Document("firstName", newUser.getFirstName())
        .append("lastName", newUser.getLastName())
        .append("email", newUser.getEmail())
        .append("username", newUser.getUsername())
        .append("password", newUser.getPassword()).append("role",newUser.getRole());

        usersCollection.insertOne(newUserDoc);
        newUser.setId(newUserDoc.get("_id").toString());

        return newUser;

        } catch (Exception e) {
        logger.error("An unexpected exception occurred.", e);
        throw new DataSourceException("An unexpected exception occurred.", e);
        }
        }



        public boolean update(AppUser updatedResource) {

        return false;
        }

        public boolean deleteById(int id) {
        return false;
        }

        }
