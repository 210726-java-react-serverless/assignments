package com.revature.Jamaal_Smith_P0.services;

import com.revature.Jamaal_Smith_P0.documents.Schedule;
import com.revature.Jamaal_Smith_P0.repos.ScheduleRepository;
import org.bson.Document;

import java.util.List;

public class ScheduleService {

    private ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }


    public Schedule view (String username, String courseNumber){
        List<Document> schedulesearch = scheduleRepository.scheduleLocator(username,courseNumber);

        return (Schedule) schedulesearch;
    }

    public Schedule delete(String username, String coursenumber){
        Schedule removeItem = scheduleRepository.deleteCourse(username,coursenumber);

        return removeItem;

    }
    public Schedule enroll(Schedule updatedSchedule){
        Schedule enrollItem = scheduleRepository.enroll(updatedSchedule);
        return enrollItem;

    }
    public Schedule search(String coursenumber, UserService username){
        Schedule courseItem = scheduleRepository.findByCourseID(coursenumber, username);
        return courseItem;
    }


}
