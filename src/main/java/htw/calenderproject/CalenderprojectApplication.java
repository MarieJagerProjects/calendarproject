package htw.calenderproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalenderprojectApplication {

	private static final Logger log = LoggerFactory.getLogger(CalenderprojectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CalenderprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EventRepository eventRepository) {
		return (args) -> {

		};
	}
}
