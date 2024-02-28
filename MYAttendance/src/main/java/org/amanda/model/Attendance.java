package org.amanda.model;

public class Attendance {
    private int studentId;
    private int sessionId;
    private boolean present;

    public Attendance(int studentId, int sessionId, boolean present) {
        this.studentId = studentId;
        this.sessionId = sessionId;
        this.present = present;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
