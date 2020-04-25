package com.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private int maxOccupancy;

    private List<Student> students;

    public Group(int maxOccupancy){
        this.maxOccupancy = maxOccupancy;
        students = new ArrayList<>();
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void add(Student student) throws GroupOccupancyExceededException{
        if(students.size() < maxOccupancy) {
            students.add(student);
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
        return 0;
    }
}
