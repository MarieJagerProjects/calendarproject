package htw.calenderproject.web;


import htw.calenderproject.EventRepository;
import htw.calenderproject.config.Endpoints;
import htw.calenderproject.config.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CalenderController {
    @Autowired
    EventRepository eventRepository;

    @GetMapping (path = Endpoints.INDEX)
    public ModelAndView showIndexPage() {
        return new ModelAndView(ViewNames.INDEX);
    }

    @GetMapping(path = Endpoints.LOGIN)
    public ModelAndView loginUser(@AuthenticationPrincipal OidcUser user, Model model) {
        String email = user.getEmail();

        model.addAttribute("email", email);
        model.addAttribute("username", user.getGivenName());

        return new ModelAndView(ViewNames.LOGIN);
    }

    @GetMapping(path = Endpoints.CALENDER)
    public ModelAndView showCalender(){
        return new ModelAndView(ViewNames.CALENDER);
    }

}
