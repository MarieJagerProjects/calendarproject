package htw.calenderproject.service;

import htw.calenderproject.exceptions.EventNotFoundException;
import htw.calenderproject.persistence.event.EventEntity;
import htw.calenderproject.persistence.event.EventRepository;
import htw.calenderproject.web.EventRequest;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent(EventRequest eventRequest) {
        EventEntity eventEntity = new EventEntity(
                eventRequest.getTitle(),
                eventRequest.getDate(),
                eventRequest.getTime(),
                eventRequest.getUser()
        );
        eventRepository.save(eventEntity);
    }
    public EventEntity loadEventById(int id) throws EventNotFoundException {
        return eventRepository
                .findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event with the id '" + id + "' not found."));
    }
}
