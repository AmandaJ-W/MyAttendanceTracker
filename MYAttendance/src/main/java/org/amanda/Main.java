package org.amanda;

import org.amanda.controller.AttendanceController;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        AttendanceController app = new AttendanceController();

        app.addStudent("Amanda Walker", true, true);
        app.addStudent("Eli Walker", false, true);

         app.markPresentAfternoon("Amanda Walker");
         app.markPresentAfternoon("Eli Walker");

//        String morningToday = app.getTotalPresentMorning();
//        String afternoonToday = app.getTotalPresentAfternoon();
//        System.out.println(afternoonToday);
//        System.out.println(morningToday);

//        app.markAbsentMorning("Amanda Walker");
//        String morningToday = app.getTotalPresentMorning();
//        System.out.println(morningToday);

        app.markAbsentAfternoon("Eli Walker");
        String afternoonToday = app.getTotalPresentAfternoon();
        System.out.println(afternoonToday);
        List<String> studentsAfternoon = app.getAfternoonPresent();
        System.out.println(studentsAfternoon);
    }
}