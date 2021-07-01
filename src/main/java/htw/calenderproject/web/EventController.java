package htw.calenderproject.web;

import htw.calenderproject.config.Endpoints;
import htw.calenderproject.persistence.event.EventEntity;
import htw.calenderproject.service.EventService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(path=Endpoints.EVENT)
    public List<EventEntity> getEvents () {
        List<EventEntity> events = eventService.getEvents();
        return events;
    }

    @PostMapping(path = Endpoints.CALENDER)
    public RedirectView saveEvent(@RequestBody EventData eventData) {
            eventService.createEvent(eventData);
        return new RedirectView(Endpoints.CALENDER);
    }

    @ModelAttribute(name = "eventRequest")
    public EventRequest eventRequest() {return new EventRequest();
    }

}

/*
Quellen:
https://frontbackend.com/thymeleaf/working-with-dates-in-thymeleaf
 */
