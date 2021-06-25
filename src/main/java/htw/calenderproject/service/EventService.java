package htw.calenderproject.service;

import htw.calenderproject.exceptions.EventNotFoundException;
import htw.calenderproject.persistence.event.EventEntity;
import htw.calenderproject.persistence.event.EventRepository;
import htw.calenderproject.web.EventRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<List<EventEntity>> loadEventsByUser(String username) {

        return eventList;
    }
}
