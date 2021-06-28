package htw.calenderproject.service;

import htw.calenderproject.persistence.event.EventEntity;
import htw.calenderproject.persistence.event.EventRepository;
import htw.calenderproject.persistence.user.UserEntity;
import htw.calenderproject.web.EventData;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final EventRepository eventRepository;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String user;


    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent(EventData eventData) {
            eventDate = LocalDate.parse(eventData.getDate(), dateFormatter);
            eventTime = LocalTime.parse(eventData.getTime());
            eventTime.truncatedTo(ChronoUnit.MINUTES);
            EventEntity eventEntity = new EventEntity(
                    eventData.getTitle(),
                    eventDate,
                    eventTime,
                    user = getCurrentUser()
            );
            eventRepository.save(eventEntity);
        }

    /*
    public EventEntity loadEventById(int id) throws EventNotFoundException {
        return eventRepository
                .findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event with the id '" + id + "' not found."));
    }

    public boolean dateIsValidFormat(String date) {
        LocalDateTime ldt;

        try {
            ldt = LocalDateTime.parse(date, dateFormatter);
            String result = ldt.format(dateFormatter);
            return result.equals(date);
        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(date, dateFormatter);
                String result = ld.format(dateFormatter);
                return result.equals(date);
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(date, dateFormatter);
                    String result = lt.format(dateFormatter);
                    return result.equals(date);
                } catch (DateTimeParseException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean timeIsValidFormat(String time) {

        try {
            LocalDateTime lt = LocalDateTime.parse(time, timeFormatter);
            String result = lt.format(timeFormatter);
            return result.equals(time);
        } catch (DateTimeParseException exp) {
            try {
                LocalTime lt = LocalTime.parse(time, timeFormatter);
                String result = lt.format(timeFormatter);
                return result.equals(time);
            } catch (DateTimeParseException e2) {
                e2.printStackTrace();
            }
            return false;
        }
    }

 */

    private String getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserEntity) {
            user = ((UserEntity)principal).getUsername();
        }
        return user;
    }


    public Optional<List<EventEntity>> loadEventsByUser() {
        Optional<List<EventEntity>> eventList = eventRepository.findAllByUsername(getCurrentUser());
        return eventList;
    }

    public List<String> getEvents() {
        List<EventEntity> eventList = new ArrayList<>();
        loadEventsByUser().ifPresent(eventList::addAll);
        List<String> events = new ArrayList<>();
        Iterator<EventEntity> iterator = eventList.iterator();
        while (iterator.hasNext()) {
            events.add(iterator.next().getTitle());
        }
        return events;
    }
}


/*
Quellen:
https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
https://stackoverflow.com/questions/20231539/java-check-the-date-format-of-current-string-is-according-to-required-format-or/20232680
https://docs.spring.io/spring-security/site/docs/4.0.2.RELEASE/reference/htmlsingle/#obtaining-information-about-the-current-user
https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
https://zetcode.com/springboot/crudrepository/
https://www.oracle.com/technical-resources/articles/java/java8-optional.html
 */