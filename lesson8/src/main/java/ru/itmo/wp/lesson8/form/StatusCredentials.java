package ru.itmo.wp.lesson8.form;

@SuppressWarnings("unused")
public class StatusCredentials {
    private String status;
    private long userId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}