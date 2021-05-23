package htw.calenderproject.web;


import htw.calenderproject.EventRepository;
import htw.calenderproject.config.Endpoints;
import htw.calenderproject.config.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalenderController {
    @Autowired
    EventRepository eventRepository;

    @GetMapping (path = Endpoints.INDEX)
    public String showIndexPage() {
        return ViewNames.INDEX;
    }
}
