package htw.calenderproject.web;

import htw.calenderproject.persistence.user.UserEntity;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventRequest {

    private UserEntity user;
    private String title;
    private LocalDate date;
    private LocalTime time;

    public UserEntity getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString(){
        return "EventRequest{" + ", title='" + title + '\'' +  ", date='" + date + '\'' + ", time='" + time + '\'' + '}';
    }
}
