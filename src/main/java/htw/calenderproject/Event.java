package htw.calenderproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Event {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String title;
    private LocalDateTime date;

    protected Event() {}

    public Event(String name, LocalDateTime date) {
        this.title = name;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
