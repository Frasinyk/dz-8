package org.example;

import java.util.ArrayList;

public class StudentsGroup {
    ArrayList<Student> studentsList = new ArrayList<Student>();
    ArrayList<String> tasksList = new ArrayList();

    Student leader;

    public void createStudent(String name) {
        Student student = new Student(studentsList.size() + 1, name);
        this.studentsList.add(student);
        if (studentsList.size() == 1) {
            this.leader = student;
        }
    }

    public void printStudentlist() {
        for (Student student : studentsList) {
            System.out.println(student.name + " " + student.id + " " + (student == this.leader ? " true" : " "));
        }
    }

    public void setLeader(String name) {
        boolean changed = false;
        for (Student student : studentsList) {
            if (student.name == name) {
                this.leader = student;
                System.out.println("new leader is " + student.name);
                changed = true;
            }
        }
        if (!changed) {
            System.out.println("Student with name " + name + " not found");
        }

    }

    public void deleteStudent(String name) {
        boolean changed = false;
        for (Student student : studentsList) {
            if (student.name == name) {
                studentsList.remove(student);
                System.out.println("student " + student.name + " is deleted");
                changed = true;
                this.leader = studentsList.get(0);
                break;
            }
        }
        if (!changed) {
            System.out.println("Student with name " + name + " not found");
        }
    }

    public void createTaskForGroup(String taskName) {
        this.tasksList.add(taskName);
    }

    public void setPassed(String name, int taskID) {
        for (Student student : studentsList) {
            if (student.name == name) {
                student.setPassedTask(taskID);
                System.out.println(student.name + this.getTaskById(taskID));
            }
        }
    }

    public String getTaskById(int taskID){
        return tasksList.get(taskID);
    }
}