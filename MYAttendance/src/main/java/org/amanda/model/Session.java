package org.amanda.model;

import java.time.LocalDate;

public class Session {
    private int sessionId;
    private LocalDate date;
    private String type; // Morning or afternoon

    public Session(LocalDate date, String type) {
        this.sessionId = sessionId;
        this.date = date;
        this.type = type;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
