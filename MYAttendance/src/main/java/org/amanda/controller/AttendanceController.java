package org.amanda.controller;

import org.amanda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class AttendanceController {
    private List<Student> roster;
    List<Student> morningRoster = new ArrayList<>();
    List<Student> afternoonRoster = new ArrayList<>();
    List<String> morningPresent = new ArrayList<>();
    List<String> afternoonPresent = new ArrayList<>();

    public AttendanceController() {
        roster = new ArrayList<>();
    }

    // Add a new student to the roster (create new student)
    public void addStudent(String name, boolean morning, boolean afternoon) {
        roster.add(new Student(name, morning, afternoon));
        for (Student student : roster) {
            if (student.getName().equals(name) && student.isMorning() && student.isAfternoon()) {
                morningRoster.add(student);
                afternoonRoster.add(student);
            } else if (student.getName().equals(name) && student.isMorning()) {
                morningRoster.add(student);
            } else if (student.getName().equals(name) && student.isAfternoon()) {
                afternoonRoster.add(student);
            }
        }
    }

    // Remove a student from the roster altogether
    public void removeStudent(String name) {
        for (Student student : roster) {
            if (student.getName().equals(name)) {
                roster.remove(student);
                return;
            }
        }
    }

    // Remove student from MORNING ONLY or AFTERNOON ONLY
    public void removeStudentOnlyAmPmSession(String name) {
        // Morning
        for (int i = 0; i < roster.size(); i++) {
            Student student = roster.get(i);
            if (student.getName().equals(name) && student.isMorning()) {
                roster.remove(i);
                i--;
            }
            // Afternoon

            if (student.getName().equals(name) && student.isAfternoon()) {
                roster.remove(i);
                i--; // Avoid IndexOutOfBoundsException
            }
        }
    }

    // Get all students enrolled in Y-Club (both sessions)
    public List<Student> getAllStudents() {
        return roster; // Change with toString method
    }

    // Get all students enrolled in morning session
    public List<Student> getMorningStudents() {
        return morningRoster;
    }

    // Get all students enrolled in afternoon session
    public List<Student> getAfternoonStudents() {
        return afternoonRoster;
    }

    /* ATTENDANCE METHODS */

    // Mark a student as present for morning session
    public void markPresentMorning(String name) {
        for (Student student : roster) {
            if (student.getName().equals(name) && student.isMorning()) {
                student.setPresent(true);
                student.setAbsent(false);
                morningPresent.add(name);
                return;
            }
        }
    }

    // Mark a student as absent for morning session
    public void markAbsentMorning(String name) {
        for (Student student : roster) {
            if (student.getName().equals(name) && student.isMorning()) {
                student.setAbsent(true);
                student.setPresent(false);
                // If student name was present on the morningPresent attendance list, then remove them
                name = student.getName();
                if (morningPresent.contains(name)) {
                    morningPresent.remove(name);
                }
            }
            return;
        }
    }


    // Mark a student as present for afternoon session
    public void markPresentAfternoon(String name) {
        for (Student student : roster) {
            if (student.getName().equals(name) && student.isAfternoon()) {
                student.setPresent(true);
                student.setAbsent(false);
                afternoonPresent.add(name);
                return;
            }
        }
    }

    // Mark a student as absent for afternoon session
    public void markAbsentAfternoon(String name) {
        for (Student student : roster) {
            if (student.getName().equals(name) && student.isAfternoon()) {
                student.setAbsent(true);
                student.setPresent(false);
                name = student.getName();
                if (afternoonPresent.contains(name)) {
                    afternoonPresent.remove(name);
                }
                return;
            }
        }
    }

    /* ENROLLMENT COUNT METHODS */

    // Count total enrolled MORNING
    public String morningTotal() {
        return "Students enrolled in morning session: " + morningRoster.size();
    }

    // Count total enrolled AFTERNOON
    public String afternoonTotal() {
        return "Students enrolled in afternoon session: " + afternoonRoster.size();
    }

    // Count total enrolled in the MORNING AND AFTERNOON (repeat students)
    public String grandEnrollmentTotal() {
        int total = morningRoster.size() + afternoonRoster.size();
        return "Total students enrolled in both morning and afternoon sessions: " + total;
    }

    /* ATTENDANCE COUNT METHODS */

    // Count total PRESENT in morning session
    public String getTotalPresentMorning() {
        int total = morningPresent.size();
        return "Total present in morning: " + total;
    }

    // Count total PRESENT in afternoon session
    public String getTotalPresentAfternoon() {
        int total = afternoonPresent.size();
        return "Total present in afternoon: " + total;
    }

    // Return students present in  morning
    public List<String> getMorningPresent() {
        return morningPresent;
    }

    public List<String> getAfternoonPresent() {
        return afternoonPresent;
    }

    // Count total present MORNING AND AFTERNOON (UNIQUE) not repeating any students who attend both sessions:
//    public String grandAttendanceUnique() {
//        int total = 0;
//
//    }

}
