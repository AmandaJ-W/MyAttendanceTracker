package org.amanda.controller;

import org.amanda.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendanceController {
    private List<Student> roster;
    List<Student> morningRoster = new ArrayList<>();
    List<Student> afternoonRoster = new ArrayList<>();

//    List<String> morningPresent = new ArrayList<>();
//    List<String> afternoonPresent = new ArrayList<>();

    public AttendanceController() {
        roster = new ArrayList<>();
    }

    /* ENROLLMENT METHODS */

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

    // Get student by name
    public String getStudentByName(String name) {
        for (Student student : roster) {
            if (student.getName().equals(name)) {
                return student.toString();
            }
        }
        return "Student not found";
    }

    // Get all students enrolled in Y-Club (both sessions)
    public List<Student> getAllStudents() {
        return roster;
    }

    public void printStudentList(List<Student> roster) {
        StringBuilder studentsInfo = new StringBuilder();
        for (Student student : roster) {
            studentsInfo.append(student.toString());
        }
        String result = studentsInfo.toString();

        result = result.replaceFirst(", Name:", "Name:");
        System.out.println(result);
    }

    // Get all students enrolled in morning session
    public List<Student> getMorningStudents() {
        return morningRoster;
    }

    // Get all students enrolled in afternoon session
    public List<Student> getAfternoonStudents() {
        return afternoonRoster;
    }

    /* ATTENDANCE MARKING METHODS */

    // CURRENT ISSUE: IT LETS YOU MARK A NON MORNING OR NON AFTERNOON STUDENT ABSENT EVEN IF THEY
    // AREN'T ENROLLED IN THAT SESSION.

    // Mark a student as present for morning session
    public void markPresentMorning(LocalDate date, String name) {
        for (Student student : roster) {
            if (student.getName().equals(name) && student.isMorning()) {
                student.markMorningAttendance(date, true);
            }
        }
        System.out.println(name + " marked present for morning session on " + date);
    }

    // Mark a student as absent for morning session
    public void markAbsentMorning(LocalDate date, String name) {
        for (Student student : roster) {
            if (student.getName().equals(name) && student.isMorning()) {
                student.markMorningAttendance(date, false);
            }
        }
        System.out.println(name + " marked absent for morning session on " + date);
    }


    // Mark a student as present for afternoon session
    public void markPresentAfternoon(LocalDate date, String name) {
        for (Student student : roster) {
            if (student.getName().equals(name) && student.isAfternoon()) {
                student.markAfternoonAttendance(date, true);
            }
        }
        System.out.println(name + " marked present for afternoon session on " + date);
    }

    // Mark a student as absent for afternoon session
    public void markAbsentAfternoon(LocalDate date, String name) {
        for (Student student : roster) {
            if (student.getName().equals(name) && student.isAfternoon()) {
                student.markAfternoonAttendance(date, false);
            }
        }
        System.out.println(name + " marked absent for afternoon session on " + date);
    }

    /* ENROLLMENT COUNTING METHODS */

    // Count total enrolled MORNING
    public String morningTotal() {
        return "Students enrolled in morning session: " + morningRoster.size();
    }

    // Count total enrolled AFTERNOON
    public String afternoonTotal() {
        return "Students enrolled in afternoon session: " + afternoonRoster.size();
    }

    // Count total enrolled in the MORNING AND AFTERNOON (WAIT! WILL repeat students)
    public String grandEnrollmentTotalAMPM() {
        int total = morningRoster.size() + afternoonRoster.size();
        return "Total students enrolled in both morning and afternoon sessions: " + total;
    }

    // Count total students for MORNING AND AFTERNOON (UNIQUE) not repeating any students who attend both sessions:
    public String grandEnrollmentUnique() {
        return "Total students enrolled: " + roster.size();
    }

    /* ATTENDANCE COUNTING METHODS */

    // Count total PRESENT in morning session
public int getTotalPresentMorning(LocalDate date) {
    int total = 0;
    for (Student student : roster) {
        Boolean present = student.getMorningAttendance(date);
        if (student.isMorning() && present != null && present) {
            total++;
        }
    }
    return total;
}

    // Count total present in AFTERNOON session
    public int getTotalPresentAfternoon(LocalDate date) {
        int total = 0;
        for (Student student : roster) {
            Boolean present = student.getAfternoonAttendance(date);
            if (present != null && present) {
                total++;
            }
        }
        return total;
    }

    // Total students ABSENT morning
    public int getTotalAbsentMorning(LocalDate date) {
        int total = 0;
        for (Student student : roster) {
            Boolean present = student.getMorningAttendance(date);
            if (student.isAfternoon() && present != null && !present) {
                total++;
            }
        }
        return total;
    }

    // Total students ABSENT afternoon
    public int getTotalAbsentAfternoon(LocalDate date) {
        int total = 0;
        for (Student student : roster) {
            Boolean present = student.getAfternoonAttendance(date);
            if (student.isAfternoon() && present != null && !present) {
                total++;
            }
        }
        return total;
    }

    // Return names of students present in morning session for a specific date
    public List<String> getMorningPresent(LocalDate date) {
        List<String> presentStudents = new ArrayList<>();
        for (Student student : roster) {
            Boolean present = student.getMorningAttendance(date);
            if (present != null && present) {
                presentStudents.add(student.getName());
            }
        }
        return presentStudents;
    }

    // Return names of students present in afternoon session for a specific date
    public List<String> getAfternoonPresent(LocalDate date) {
        List<String> presentStudents = new ArrayList<>();
        for (Student student : roster) {
            Boolean present = student.getAfternoonAttendance(date);
            if (present != null && present) {
                presentStudents.add(student.getName());
            }
        }
        return presentStudents;
    }

}
