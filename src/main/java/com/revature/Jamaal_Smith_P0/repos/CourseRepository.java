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

public class CourseRepository implements CrudRepository<Document> {


    @Override
    public Document save(Document newResource) {
        return null;
    }

    @Override
    public boolean update(Document updatedResource) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    //put in MongoDriver logic to complete
    @Override
    public Document findById(int courseNumber) {
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase userDatabase = mongoClient.getDatabase("project0");
            MongoCollection<Document> courseCollection = userDatabase.getCollection("courses");
            Document queryDoc = new Document("courseNumber", courseNumber);
            Document courseDoc = courseCollection.find(queryDoc).first();

            if (courseDoc == null) {
                return null;
            }

            ObjectMapper mapper = new ObjectMapper();
            AppUser authUser = mapper.readValue(courseDoc.toJson(), AppUser.class);
            authUser.setId(courseDoc.get("_id").toString());
            return courseDoc;

        } catch (JsonMappingException jme) {
            logger.error("An exception occurred while mapping the document.", jme);
            throw new DataSourceException("An exception occurred while mapping the document.", jme);
        } catch (Exception e) {
            logger.error("An unexpected exception occurred.", e);
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }

    private final Logger logger = LogManager.getLogger(UserRepository.class);
}
