package htw.calenderproject.persistence.event;

import htw.calenderproject.persistence.user.UserEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "event")
public class EventEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user", nullable = false)
    private UserEntity userEntity;

    protected EventEntity( ) {
        super();
    }

    public EventEntity(String name, LocalDate date, LocalTime time) {
        super( );
        this.title = name;
        this.date = date;
        this.time = time;
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

    public UserEntity getUser() {
        return userEntity;
    }
}
