package htw.calenderproject.web;


import htw.calenderproject.EventRepository;
import htw.calenderproject.config.Endpoints;
import htw.calenderproject.config.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CalenderController {
    @Autowired
    EventRepository eventRepository;

    @Value("Marie")
    private String user;

    @GetMapping (path = Endpoints.INDEX)
    public ModelAndView showIndexPage() {
        return new ModelAndView(ViewNames.INDEX);
    }

    @GetMapping(path=Endpoints.CALENDER)
    public ModelAndView eventOverview(Model model){
        var mav = new ModelAndView();
        mav.addObject("user", user);
        mav.setViewName(ViewNames.CALENDER);
        return mav;
    }
}
