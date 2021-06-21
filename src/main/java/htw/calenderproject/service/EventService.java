package htw.calenderproject.service;

import htw.calenderproject.persistence.event.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent()
}
