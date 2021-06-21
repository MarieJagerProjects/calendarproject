package htw.calenderproject.persistence.event;

import htw.calenderproject.persistence.user.UserEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class EventEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private LocalDate date;
    private LocalDate time;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="username", nullable = false)
    private UserEntity userEntity;

    protected EventEntity( ) {
        super();
    }

    public EventEntity(String name, LocalDate date, LocalDate time) {
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

    public LocalDate getTime() {
        return time;
    }

    public UserEntity getUser() {
        return userEntity;
    }
}
