package htw.calenderproject.persistence.event;

import htw.calenderproject.persistence.user.UserEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "event")
public class EventEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name="username", nullable = false)
    private String username;

    protected EventEntity( ) {
        super();
    }

    public EventEntity(String name, LocalDate date, LocalTime time, String username) {
        super( );
        this.title = name;
        this.date = date;
        this.time = time;
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getUser() {
        return username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

}
