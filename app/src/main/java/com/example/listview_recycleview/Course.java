package com.example.listview_recycleview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Course {
    String name;
    String teacherName;
    int lectures;

    public Course(String name, String teacherName, int lectures) {
        this.name = name;
        this.teacherName = teacherName;
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getLectures() {
        return lectures;
    }


    public static final String[] coursename={
            "a","b","c","d","e"
    };

    public static final String [] teachers={
            "vipin","rimjhim","rahul","ray","savita"
    };
    public static ArrayList<Course> generateNRandomteachers(int n){
        ArrayList<Course> courses=new ArrayList<>();
        Random r=new Random();
        for(int i=0;i<n;i++){
            Course course=new
                    Course(
                            teachers[r.nextInt(5)],
                            coursename[r.nextInt(5)],
                      10+ r.nextInt(10)
            );
            courses.add(course);
        }
        return courses;
    }

}
