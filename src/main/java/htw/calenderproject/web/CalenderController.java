package htw.calenderproject.web;


import htw.calenderproject.EventRepository;
import htw.calenderproject.config.Endpoints;
import htw.calenderproject.config.ViewNames;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CalenderController {
    @Autowired
    EventRepository eventRepository;

    @GetMapping (path = Endpoints.INDEX)
    public ModelAndView showIndexPage() {
        return new ModelAndView(ViewNames.INDEX);
    }

    @GetMapping(path=Endpoints.CALENDER)
    public ModelAndView eventOverview(@AuthenticationPrincipal User user, Model model){
        String username = user.getUsername();
        var mav = new ModelAndView();
        mav.addObject("username", username);
        mav.setViewName(ViewNames.CALENDER);
        return mav;
    }
}
