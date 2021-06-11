package htw.calenderproject.web;

import htw.calenderproject.config.Endpoints;
import htw.calenderproject.config.ViewNames;
import htw.calenderproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegistrationController {

        private final UserService userService;

        public RegistrationController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping(path = Endpoints.REGISTER)
        public ModelAndView showRegistrationPage() {
            return new ModelAndView(ViewNames.REGISTER);
        }

        @PostMapping(path = Endpoints.REGISTER)
        public RedirectView handleRegistrationRequest(RegistrationRequest registrationRequest) {
            userService.createUser(registrationRequest);
            return new RedirectView(Endpoints.LOGIN + "?registrationSuccessful");
        }

        @ModelAttribute(name = "registrationRequest")
        public RegistrationRequest registrationRequest() {
            return new RegistrationRequest();
        }
}
