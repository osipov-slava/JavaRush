package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int age;
    private String name;

    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudentWithAverageGrade(double avarageGrade) {
        for (Student student: students) {
            if (student.getAverageGrade() == avarageGrade) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxAvaregeGrade = 0.0;
        Student studentWithMaxAvegageGrade = null;
        for (Student student: students) {
            if (student.getAverageGrade() > maxAvaregeGrade) {
                maxAvaregeGrade = student.getAverageGrade();
                studentWithMaxAvegageGrade = student;
            }
        }
        return studentWithMaxAvegageGrade;
    }

    public Student getStudentWithMinAverageGrade(){
        double minAvaregeGrade = 10;
        Student studentWithMinAvegageGrade = null;
        for (Student student: students) {
            if (student.getAverageGrade() < minAvaregeGrade) {
                minAvaregeGrade = student.getAverageGrade();
                studentWithMinAvegageGrade = student;
            }
        }
        return studentWithMinAvegageGrade;
    }

    public void expel(Student student){
        students.remove(student);
    }


}