package com.revature.Jamaal_Smith_P0.documents;

import java.util.Objects;

public class Course {
    String department;
    String title;
    String teacher;
    String description;
    int courseNumber;

    public Course(String department, String title, String teacher, String description, int courseNumber) {
        this.department = department;
        this.title = title;
        this.teacher = teacher;
        this.description = description;
        this.courseNumber = courseNumber;
    }

    public Course() {
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(department, course.department) && Objects.equals(title, course.title)
                && Objects.equals(teacher, course.teacher) && Objects.equals(description, course.description)
                && Objects.equals(courseNumber, course.courseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, title, teacher, description, courseNumber);
    }

    @Override
    public String toString() {
        return "course{" +
                "department='" + department + '\'' +
                ", title='" + title + '\'' +
                ", teacher='" + teacher + '\'' +
                ", description='" + description + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                '}';
    }
}
