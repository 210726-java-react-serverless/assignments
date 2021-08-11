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

/** This class houses all of the tasks that will be performed related to courses in the
 * enrollment system.
 */

public class CourseRepository implements CrudRepository<Course> {

    private Course newCourse;
    private Document courseDoc;
    private final Logger logger = LogManager.getLogger(CourseRepository.class);
    private Course newResource;


    @Override
    public boolean deleteById(int id) {
        return false;
    }

    //put in MongoDriver logic to complete
    @Override
    /** This method allows for a course to be located in the database by entering its
     * course number in the form of a string
     */
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



    @Override
    public Course update(String updatedResource) {
        return null;
    }

    /** This method allows one to add a new course to the registry
     *
     * @param newResource
     * @return
     */
    public Course save(Course newResource) {
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase courseDatabase = mongoClient.getDatabase("project0");
            MongoCollection<Document> courseCollection = courseDatabase.getCollection("courses");
            Document newCourseItem = new Document("department", this.newResource.getDepartment())
                    .append("title", this.newResource.getTitle())
                    .append("teacher", this.newResource.getTeacher())
                    .append("description", this.newResource.getDescription())
                    .append("course_number", this.newResource.getCourseNumber());

            courseCollection.insertOne(newCourseItem);

            return this.newResource;

        }
        catch (Exception e) {
            logger.error("An unexpected exception occurred.", e);
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }

    /** This method allows one to remove a course from the catalog by providing its course number.
     * @param courseNumber
     * @return
     */
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

    public Course save(){
        return null;
    }

    public Course saveReal(Course newCourse) {
        System.out.println("we made it");
        try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase courseDatabase = mongoClient.getDatabase("project0");
            MongoCollection<Document> courseCollection = courseDatabase.getCollection("courses");
            Document newCourseItem = new Document( "course_number", this.newCourse.getCourseNumber())
                    .append("department",this.newCourse.getDepartment())
                    .append("title", this.newCourse .getTitle())
                    .append("teacher", this.newCourse.getTeacher())
                    .append("description", this.newCourse.getDescription());


            courseCollection.insertOne(newCourseItem);

            return newCourse;

        }
        catch (Exception e) {
            logger.error("An unexpected exception occurred.", e);
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }

    /** This method enables for a course that already exists in the database to be deleted
     *
     * @param course
     * @param newCourse
     * @return
     */
    public Course updatereal(Course course, Course newCourse) {
        try{
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase courseDatabase = mongoClient.getDatabase("project0");
            MongoCollection<Document> courseCollection = courseDatabase.getCollection("courses");
            courseCollection.updateOne(Filters.eq("courseNumber", newCourse.getCourseNumber()), Updates.combine(
                    Updates.set("title",newCourse.getTitle()), Updates.set("department",newCourse.getDepartment()),
                    Updates.set("description",newCourse.getDescription()),Updates.set("teacher",newCourse.getTeacher())));

            return newCourse;
        }catch(Exception e) {
            logger.error(e);
        }return null;
    }

    }

