package htw.calenderproject.web;

import htw.calenderproject.config.Endpoints;
import htw.calenderproject.config.ViewNames;
import htw.calenderproject.persistence.event.EventEntity;
import htw.calenderproject.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(path=Endpoints.CALENDER)
    public ModelAndView showCalender (Model model) {
        ModelAndView mav = new ModelAndView(ViewNames.CALENDER);
        mav.addObject(eventService.loadEventsByUser());
        return mav;
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
