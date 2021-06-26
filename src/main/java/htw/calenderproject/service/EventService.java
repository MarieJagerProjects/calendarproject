package htw.calenderproject.service;

import htw.calenderproject.exceptions.EventNotFoundException;
import htw.calenderproject.exceptions.IncorrectUserInputException;
import htw.calenderproject.persistence.event.EventEntity;
import htw.calenderproject.persistence.event.EventRepository;
import htw.calenderproject.persistence.user.UserEntity;
import htw.calenderproject.web.EventData;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm");
    private final EventRepository eventRepository;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private UserEntity user;


    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent(EventData eventData) {
        if(dateIsValidFormat(eventData.getDate()) && timeIsValidFormat(eventData.getTime())) {
            eventDate = LocalDate.parse(eventData.getDate(), dateFormatter);
            eventTime = LocalTime.parse(eventData.getTime(), timeFormatter);
        } else throw new IncorrectUserInputException("The format was not as expected. Please check again.");
        EventEntity eventEntity = new EventEntity(
                eventData.getTitle(),
                eventDate,
                eventTime,
                user = getCurrentUser()
        );
        eventRepository.save(eventEntity);
    }

    public EventEntity loadEventById(int id) throws EventNotFoundException {
        return eventRepository
                .findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event with the id '" + id + "' not found."));
    }

    public boolean dateIsValidFormat(String date) {

        try {
            LocalDate ld = LocalDate.parse(date, dateFormatter);
            String result = ld.format(dateFormatter);
            return result.equals(date);
        } catch (DateTimeParseException exp) {
            exp.printStackTrace();
        }
        return false;
    }

    public boolean timeIsValidFormat(String time) {

        try {
            LocalTime lt = LocalTime.parse(time, timeFormatter);
            String result = lt.format(timeFormatter);
            return result.equals(time);
        } catch (DateTimeParseException exp) {
            exp.printStackTrace();
        }
        return false;
    }

    private UserEntity getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserEntity) {
            user = ((UserEntity)principal);
        }
        return user;
    }

/*
    public Optional<List<EventEntity>> loadEventsByUser(String username) {

        return eventList;
    }*/
}


/*
Quellen:
https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
https://stackoverflow.com/questions/20231539/java-check-the-date-format-of-current-string-is-according-to-required-format-or/20232680
https://www.tutorialspoint.com/convert-string-of-time-to-time-object-in-java
https://docs.spring.io/spring-security/site/docs/4.0.2.RELEASE/reference/htmlsingle/#obtaining-information-about-the-current-user
 */