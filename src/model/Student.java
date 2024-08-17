package model;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private double[] score;
    private String gender;
    private String hanhKiem;
    private int clazzId;
    private static int nextId = 1;

    public Student(String name, double[] score, String gender, String hanhKiem, int clazzId) {
        this.id = nextId++;
        this.name = name;
        this.score = score;
        this.gender = gender;
        this.hanhKiem = hanhKiem;
        this.clazzId = clazzId;
    }

    public Student(int id, String name, double[] score, String gender, String hanhKiem, int clazzId) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.gender = gender;
        this.hanhKiem = hanhKiem;
        this.clazzId = clazzId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getScore() {
        return score;
    }

    public void setScore(double[] score) {
        this.score = score;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHanhKiem() {
        return hanhKiem;
    }

    public void setHanhKiem(String hanhKiem) {
        this.hanhKiem = hanhKiem;
    }

    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                "|| name='" + name + '\'' +
                "|| score=" + Arrays.toString(score) +
                "|| gender='" + gender + '\'' +
                "|| hanhKiem='" + hanhKiem + '\'' +
                "|| clazzId=" + clazzId +
                '}';
    }
}
