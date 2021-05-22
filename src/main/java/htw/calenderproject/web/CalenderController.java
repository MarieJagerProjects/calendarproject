package htw.calenderproject.web;


import htw.calenderproject.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalenderController {
    @Autowired
    EventRepository eventRepository;

    @RequestMapping
    public String homepage() {
        return "Calender";
    }
}
