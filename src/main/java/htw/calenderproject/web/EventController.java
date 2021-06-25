package htw.calenderproject.web;

import htw.calenderproject.config.Endpoints;
import htw.calenderproject.config.ViewNames;
import htw.calenderproject.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(path = Endpoints.EVENT)
    public ModelAndView showNewEventPage () {
        return new ModelAndView(ViewNames.EVENT);
    }

    @PostMapping(path = Endpoints.EVENT)
    public RedirectView saveEvent(EventRequest eventRequest) {
        eventService.createEvent(eventRequest);
        return new RedirectView(Endpoints.CALENDER);
    }

    @ModelAttribute(name = "eventRequest")
    public EventRequest eventRequest() {return new EventRequest();
    }
}
