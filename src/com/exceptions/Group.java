package com.exceptions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {

    private int maxOccupancy;

    private Set<String> studentIds;
    private List<Student> students;

    public Group(int maxOccupancy){
        this.maxOccupancy = maxOccupancy;
        students = new ArrayList<>();
        studentIds = new HashSet<>();
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void add(Student student) throws GroupOccupancyExceededException{

        if (studentIds.contains(student.getId())){
                return;
        }

        if(students.size() < maxOccupancy) {
            students.add(student);
            studentIds.add(student.getId());
        }else {
            throw new GroupOccupancyExceededException();
        }

    }

    public List<Student> getStudents(){

        return students;
    }

    public int availability() {
        return maxOccupancy - students.size();
    }

    public double getAverage() {
        double sum=0;

        for (Student student : students) {
            if(student.getGrade() == null){
                throw new MissedGradeException();
            }
            sum +=student.getGrade();
        }
        return sum/students.size();
    }
}
