package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student {
    int id;
    String name;
    ArrayList<Integer> passedTasks = new ArrayList();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public void setPassedTask (int taskID){
        this.passedTasks.add(taskID);

    }

}
