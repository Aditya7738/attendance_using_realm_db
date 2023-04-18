package com.example.internalexamrealm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DataModel extends RealmObject {

    //private String firstStudentName, secondStudentName, thirdStudentName, forthStudentName;
    //private String firstStudentAttendance, secondStudentAttendance, thirdStudentAttendance, forthStudentAttendance;
    private String studentName;
    private String studentAttendance;
    @PrimaryKey
    private long id;

    public DataModel(){}

    /*public String getFirstStudentName() {
        return firstStudentName;
    }

    public void setFirstStudentName(String firstStudentName) {
        this.firstStudentName = firstStudentName;
    }

    public String getSecondStudentName() {
        return secondStudentName;
    }

    public void setSecondStudentName(String secondStudentName) {
        this.secondStudentName = secondStudentName;
    }

    public String getThirdStudentName() {
        return thirdStudentName;
    }

    public void setThirdStudentName(String thirdStudentName) {
        this.thirdStudentName = thirdStudentName;
    }

    public String getForthStudentName() {
        return forthStudentName;
    }

    public void setForthStudentName(String forthStudentName) {
        this.forthStudentName = forthStudentName;
    }

    public String getFirstStudentAttendance() {
        return firstStudentAttendance;
    }

    public void setFirstStudentAttendance(String firstStudentAttendance) {
        this.firstStudentAttendance = firstStudentAttendance;
    }

    public String getSecondStudentAttendance() {
        return secondStudentAttendance;
    }

    public void setSecondStudentAttendance(String secondStudentAttendance) {
        this.secondStudentAttendance = secondStudentAttendance;
    }

    public String getThirdStudentAttendance() {
        return thirdStudentAttendance;
    }

    public void setThirdStudentAttendance(String thirdStudentAttendance) {
        this.thirdStudentAttendance = thirdStudentAttendance;
    }

    public String getForthStudentAttendance() {
        return forthStudentAttendance;
    }

    public void setForthStudentAttendance(String forthStudentAttendance) {
        this.forthStudentAttendance = forthStudentAttendance;
    }*/
    public void setId(long nextId) {
        this.id = nextId;
    }

    public long getId() {
        return id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentAttendance(String studentAttendance) {
        this.studentAttendance = studentAttendance;
    }

    public String getStudentAttendance() {
        return studentAttendance;
    }


}
