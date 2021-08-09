package com.revature.Jamaal_Smith_P0.repos;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.revature.Jamaal_Smith_P0.documents.Course;
import com.revature.Jamaal_Smith_P0.util.Other.MongoClientFactory;
import com.revature.Jamaal_Smith_P0.util.exceptions.DataSourceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

public class CourseRepository implements CrudRepository<Course> {

    private Course newCourse;
    private Document courseDoc;
    private final Logger logger = LogManager.getLogger(CourseRepository.class);



    @Override
    public boolean update(Course updatedResource) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    //put in MongoDriver logic to complete
    @Override
    public Course findById(String courseNumber) {
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
            Course locatedCourse = mapper.readValue(courseDoc.toJson(),Course.class);
            return locatedCourse;



        } catch (JsonMappingException jme) {
            logger.error("An exception occurred while mapping the document.", jme);
            throw new DataSourceException("An exception occurred while mapping the document.", jme);
        } catch (Exception e) {
            logger.error("An unexpected exception occurred.", e);
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }


    //Method to add courses to the database

    public Course save(Course newCourse) {
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase courseDatabase = mongoClient.getDatabase("project0");
            MongoCollection<Document> courseCollection = courseDatabase.getCollection("courses");
            Document newCourseItem = new Document("department", newCourse.getDepartment())
                    .append("title", newCourse.getTitle())
                    .append("teacher", newCourse.getTeacher())
                    .append("description", newCourse.getDescription())
                    .append("course_number", newCourse.getCourseNumber());

            courseCollection.insertOne(newCourseItem);

            return newCourse;

        }
        catch (Exception e) {
            logger.error("An unexpected exception occurred.", e);
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }

    public Course removeCourse(String courseNumber) {
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase courseDatabase = mongoClient.getDatabase("project0");
            MongoCollection<Document> courseCollection = courseDatabase.getCollection("courses");
            Document queryDoc = new Document("courseNumber", courseNumber);
            Document removalItem = courseCollection.find(queryDoc).first();

            if (removalItem == null) {
                return null;
            }

            courseCollection.deleteOne(removalItem);

        } catch (Exception e) {
            logger.error("An unexpected exception occurred.", e);
        }
        return null;
    }

    public Course updateCourse(Course course, Course newCourse) {
        try{
        MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
        MongoDatabase courseDatabase = mongoClient.getDatabase("project0");
        MongoCollection<Document> courseCollection = courseDatabase.getCollection("courses");
        courseCollection.updateOne(Filters.eq("courseNumber", course.getCourseNumber()), Updates.combine(
         Updates.set("title",newCourse.getTitle()), Updates.set("department",newCourse.getDepartment()),
                Updates.set("description",newCourse.getDescription()),Updates.set("teacher",newCourse.getTeacher())));

        return newCourse;
    }catch(Exception e){
        logger.error(e);
        }
        return null;
    }
}
