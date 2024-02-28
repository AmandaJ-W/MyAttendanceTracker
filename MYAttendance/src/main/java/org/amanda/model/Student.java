package org.amanda.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private int id;
    private String name;

    /* Enrollment */
    private boolean morning; // Whether the student is enrolled in morning session
    private boolean afternoon; // Whether the student is enrolled in afternoon session

    /* Attendance */
    private Map<LocalDate, Boolean> morningAttendance;
    private Map<LocalDate, Boolean> afternoonAttendance;
    private boolean presentMorning; // Whether the student is present in the morning
    private boolean presentAfternoon; // Whether the student is present in the afternoon

    private boolean absentMorning;
    private boolean absentAfternoon;

    public Student(int id, String name, boolean morning, boolean afternoon) {
        this.id = id;
        this.name = name;
        this.morning = morning;
        this.afternoon = afternoon;
        this.morningAttendance = new HashMap<>();
        this.afternoonAttendance = new HashMap<>();
    }

    public boolean isAbsentMorning() {
        return absentMorning;
    }

    public void setAbsentMorning(LocalDate date, boolean absentMorning) {
        this.absentMorning = absentMorning;
    }

    public boolean isAbsentAfternoon() {
        return absentAfternoon;
    }

    public void setAbsentAfternoon(LocalDate date, boolean absentAfternoon) {
        this.absentAfternoon = absentAfternoon;
    }

    public boolean isPresentMorning() {
        return presentMorning;
    }

    public void setPresentMorning(LocalDate date, boolean presentMorning) {
        this.presentMorning = presentMorning;
    }

    public boolean isPresentAfternoon() {
        return presentAfternoon;
    }

    public void setPresentAfternoon(LocalDate date, boolean presentAfternoon) {
        this.presentAfternoon = presentAfternoon;
    }

    public void markMorningAttendance(LocalDate date, boolean present) {
        morningAttendance.put(date, present);
    }

    public void markAfternoonAttendance(LocalDate date, boolean present) {
        afternoonAttendance.put(date, present);
    }

    public Boolean getMorningAttendance(LocalDate date) {
        return morningAttendance.get(date);
    }

    public Boolean getAfternoonAttendance(LocalDate date) {
        return afternoonAttendance.get(date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMorning() {
        return morning;
    }

    public void setMorning(boolean morning) {
        this.morning = morning;
    }

    public boolean isAfternoon() {
        return afternoon;
    }

    public void setAfternoon(boolean afternoon) {
        this.afternoon = afternoon;
    }

    public String toString() {
        String morningStatus = morning ? (presentMorning ? "Yes" : "No") : "N/A";
        String afternoonStatus = afternoon ? (presentAfternoon ? "Yes" : "No") : "N/A";

        return  "Name: " + name + "\n" +
                "Enrolled (Morning and/or afternoon):\n" +
                "Morning: " + morning + "\n" +
                "Afternoon: " + afternoon + "\n\n";
//                "Present today?:\n" +
//                "Morning: " + morningStatus + "\n" +
//                "Afternoon: " + afternoonStatus + "\n\n";
    }

}
