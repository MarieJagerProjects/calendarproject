package htw.calenderproject.web;

import java.time.LocalDate;
import java.time.LocalTime;

public class SavingRequest {

    private String username;
    private String title;
    private LocalDate date;
    private LocalTime time;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "SavingRequest{" + "username='" + username + '\'' + ", title='" + title + '\'' +  ", date='" + date + '\'' + ", time='" + time + '\'' + '}';
    }
}
