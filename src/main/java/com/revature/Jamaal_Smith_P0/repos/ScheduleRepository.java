package com.revature.Jamaal_Smith_P0.repos;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.revature.Jamaal_Smith_P0.documents.Schedule;
import com.revature.Jamaal_Smith_P0.services.UserService;
import com.revature.Jamaal_Smith_P0.util.Other.MongoClientFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;


import java.util.ArrayList;
import java.util.List;

public class ScheduleRepository implements CrudRepository<Schedule>  {
    private final Logger logger = LogManager.getLogger(ScheduleRepository.class);


    public Schedule enroll (Schedule updatedSchedule){
        try{
        MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
        MongoDatabase courseDatabase = mongoClient.getDatabase("project0");
        MongoCollection<Document> scheduleCollection = courseDatabase.getCollection("schedule");
        Document scheduledItem = new Document("username", updatedSchedule.getUsername())
                .append("title",updatedSchedule.getTitle())
                .append("courseNumber",updatedSchedule.getCourseNumber())
                .append("teacher",updatedSchedule.getTeacher())
                .append("description",updatedSchedule.getDescription());

        scheduleCollection.insertOne(scheduledItem);

        return updatedSchedule;

    }catch(Exception e){
            logger.error(e);
        }
        return null;
    }

        public Schedule findByCourseID(String courseNumber, UserService username){
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase courseDatabase = mongoClient.getDatabase("project0");
            MongoCollection<Document> scheduleCollection = courseDatabase.getCollection("schedule");
            Document querydoc = new Document("username",username).append("coursenumber",courseNumber);
            Document outputdoc = scheduleCollection.find(querydoc).first();

            if(outputdoc == null){
                return  null;
            }
            ObjectMapper mapper = new ObjectMapper();
            try {
                Schedule outcourse = mapper.readValue(outputdoc.toJson(), Schedule.class);
                return outcourse;

            } catch (JsonProcessingException e) {
                logger.error(e);
            } return null;

        }
        public Schedule deleteCourse(String username, String courseNumber) {
            try {
                MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
                MongoDatabase courseDatabase = mongoClient.getDatabase("project0");
                MongoCollection<Document> scheduleCollection = courseDatabase.getCollection("schedule");
                Document querydoc = new Document("username", username).append("courseNumber", courseNumber);
                Document removal = scheduleCollection.find(querydoc).first();

                if (removal == null) {
                    return null;
                }
                scheduleCollection.deleteOne(removal);

            } catch (Exception e) {
                logger.error(e);
            }
            return null;
        }
        public List<Document> scheduleLocator (String username, String courseNumber){
        List<Schedule> studentSchedule = new ArrayList<>();
            try {
            MongoClient mongoClient = MongoClientFactory.getInstance().getConnection();
            MongoDatabase courseDatabase = mongoClient.getDatabase("project0");
            MongoCollection<Document> scheduleCollection = courseDatabase.getCollection("schedule");
            Document user = new Document ("username",username);
            List<Document> schedulesList = scheduleCollection.find(update(username)).into(new ArrayList<>());

            ObjectMapper mapper = new ObjectMapper();

            for(Document schedule : schedulesList) {
                Schedule schedules = mapper.readValue(schedule.toJson(), Schedule.class);
                schedulesList.add(schedules);
            }
            return schedulesList;

                } catch (JsonProcessingException e) {
                    logger.error(e);
                }
            return null;
            }








    @Override
    public Schedule findById(String T) {
        return null;
    }

    @Override
    public Schedule save(Schedule newResource) {
        return null;
    }

    @Override
    public Schedule update(String updatedResource) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
