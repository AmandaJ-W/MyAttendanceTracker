package org.amanda;

import org.amanda.controller.AttendanceController;
import org.amanda.model.Student;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        AttendanceController app = new AttendanceController();

        app.addStudent("Amanda Walker", true, true);
        app.addStudent("Eli Walker", false, true);


        List<Student> roster = app.getAllStudents();
        app.printStudentList(roster);

//
//        app.markPresentMorning(LocalDate.of(2024, 2, 26), "Amanda Walker");
//        app.markPresentMorning(LocalDate.of(2024, 2, 26), "Eli Walker");
//
//        int totalPresentToday = app.getTotalPresentMorning(LocalDate.of(2024, 2, 26));
//        System.out.println(totalPresentToday);


    }
}