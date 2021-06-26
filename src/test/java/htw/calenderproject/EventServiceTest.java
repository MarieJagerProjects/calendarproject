package htw.calenderproject;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import htw.calenderproject.persistence.user.UserRepository;
import htw.calenderproject.service.EventService;
import htw.calenderproject.service.UserService;
import htw.calenderproject.web.EventController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EventController.class)
public class EventServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @MockBean
    private UserService userService;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @WithMockUser(value = "test")
    @Test
    @DisplayName("should return false for wrong date format")
    public void testDateIsValidFormat() throws Exception {

    }

    @Test
    @DisplayName("should return true for right date format")
    void testDateIsValidFormat2() {

    }

    @Test
    @DisplayName("should return false for wrong time format")
    void testTimeIsValidFormat() {

    }

    @Test
    @DisplayName("should return true for right time format")
    void testTimeIsValidFormat2() {

    }

}

/*
Quellen:
https://www.baeldung.com/spring-security-integration-tests
 */