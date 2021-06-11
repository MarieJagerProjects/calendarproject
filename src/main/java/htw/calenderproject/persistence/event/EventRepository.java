package htw.calenderproject.persistence.event;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByUserName(String userName);
    Event findById(long id);
    Event findByDate(LocalDateTime date);
}
