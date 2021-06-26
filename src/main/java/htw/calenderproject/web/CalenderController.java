package htw.calenderproject.web;


import htw.calenderproject.config.Endpoints;
import htw.calenderproject.config.ViewNames;
import htw.calenderproject.service.EventService;
import htw.calenderproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;


@Controller
public class CalenderController {

    LocalDate today = java.time.LocalDate.now();
    private final UserService userService;

    public CalenderController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping (path = Endpoints.INDEX)
    public ModelAndView showIndexPage(Model model) {
        var mav = new ModelAndView();
        mav.addObject("today", today);
        mav.setViewName((ViewNames.INDEX));
        return mav;
    }

    @GetMapping(path = Endpoints.LOGIN)
    public ModelAndView userLogin (Model model, @RequestParam(name = "badCredentials", required = false) String badCredentials) {
        var mav = new ModelAndView();
        mav.addObject("badCredentials", badCredentials);
        mav.setViewName((ViewNames.LOGIN));
        return mav;
    }

    @GetMapping(path=Endpoints.CALENDER)
    public ModelAndView showCalender (Model model, String username) {
        ModelAndView mav = new ModelAndView(ViewNames.CALENDER);

        return mav;
    }

}
