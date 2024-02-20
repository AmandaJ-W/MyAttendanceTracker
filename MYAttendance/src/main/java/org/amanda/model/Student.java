package org.amanda.model;

public class Student {
    private String name;
    private boolean morning; // Whether the student is enrolled in morning session
    private boolean afternoon; // Whether the student is enrolled in afternoon session
    private boolean present = true;
    private boolean absent = false;

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public boolean isAbsent() {
        return absent;
    }

    public void setAbsent(boolean absent) {
        this.absent = absent;
    }

    public Student(String name, boolean morning, boolean afternoon) {
        this.name = name;
        this.morning = morning;
        this.afternoon = afternoon;
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
        String presentStatus = isPresent() ? "Yes" : "No";
        return "*Y-Club Student*\n" +
                "Name: " + name + "\n" +
                "Enrollment status:\n" +
                "Morning: " + morning + "\n" +
                "Afternoon: " + afternoon + "\n" +
                "Present today?: " + presentStatus + "\n";
    }

}
