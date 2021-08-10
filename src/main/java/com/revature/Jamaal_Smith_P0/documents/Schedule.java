package com.revature.Jamaal_Smith_P0.documents;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

public class Schedule {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String courseNumber;
    private String username;
    private String teacher;
    private String description;
    private String title;

    public Schedule (String courseNumber,String username, String teacher, String description, String title) {
        this.courseNumber = courseNumber;
        this.username = username;
        this.teacher = teacher;
        this.description = description;
        this.title = title;
    }

    public Schedule() {
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "courseNumber='" + courseNumber + '\'' +
                ", username='" + username + '\'' +
                ", teacher='" + teacher + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(courseNumber, schedule.courseNumber) && Objects.equals(username, schedule.username) && Objects.equals(teacher, schedule.teacher) && Objects.equals(description, schedule.description) && Objects.equals(title, schedule.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseNumber, username, teacher, description, title);
    }
}

