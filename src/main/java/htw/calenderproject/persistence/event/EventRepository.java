package htw.calenderproject.persistence.event;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Long> {
    List<EventEntity> findByUserName(String userName);
    EventEntity findById(long id);
    EventEntity findByDate(LocalDate date);
    EventEntity findByTime(LocalTime time);
}
