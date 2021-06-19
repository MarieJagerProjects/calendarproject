package htw.calenderproject.web;


import htw.calenderproject.config.Endpoints;
import htw.calenderproject.config.ViewNames;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;


@Controller
public class CalenderController {

    LocalDate today = java.time.LocalDate.now();

    @GetMapping (path = Endpoints.INDEX)
    public ModelAndView showIndexPage(Model model) {
        var mav = new ModelAndView();
        mav.addObject("today", today);
        mav.setViewName((ViewNames.INDEX));
        return mav;
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
