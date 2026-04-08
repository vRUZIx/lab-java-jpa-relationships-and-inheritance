package com.example.demo.config;

import com.example.demo.Entity.BillableTask;
import com.example.demo.Entity.Conference;
import com.example.demo.Entity.Contact;
import com.example.demo.Entity.Exhibition;
import com.example.demo.Entity.Guest;
import com.example.demo.Entity.GuestStatus;
import com.example.demo.Entity.InternalTask;
import com.example.demo.Entity.Name;
import com.example.demo.Entity.Speaker;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.TaskRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LabDataLoader {

    @Bean
    CommandLineRunner seedLabData(
        ContactRepository contactRepository,
        EventRepository eventRepository,
        TaskRepository taskRepository
    ) {
        return args -> {
            if (contactRepository.count() == 0) {
                List<Contact> contacts = List.of(
                    new Contact("BlueSky PR", "Director", new Name("Dr.", "Elena", "M.", "Rios")),
                    new Contact("Nova Media", "Coordinator", new Name("Ms.", "Paula", "A.", "Lopez")),
                    new Contact("Summit Group", "Analyst", new Name("Mr.", "Daniel", "J.", "Santos"))
                );
                contactRepository.saveAll(contacts);
            }

            if (eventRepository.count() == 0) {
                Conference conference = new Conference("Spring Data Summit", LocalDate.now().plusDays(10), 8, "Madrid");
                conference.addGuest(new Guest("Carlos Ruiz", GuestStatus.ATTENDING));
                conference.addGuest(new Guest("Andrea Nunez", GuestStatus.NO_RESPONSE));
                conference.addGuest(new Guest("Miguel Pardo", GuestStatus.NOT_ATTENDING));
                conference.addSpeaker(new Speaker("Lucia Vega", 45));
                conference.addSpeaker(new Speaker("Ruben Moya", 30));

                Exhibition exhibition = new Exhibition("Healthcare Expo", LocalDate.now().plusDays(20), 6, "Barcelona");
                exhibition.addGuest(new Guest("Marta Leon", GuestStatus.ATTENDING));
                exhibition.addGuest(new Guest("Iker Sola", GuestStatus.ATTENDING));
                exhibition.addGuest(new Guest("Nora Ruiz", GuestStatus.NO_RESPONSE));

                eventRepository.saveAll(List.of(conference, exhibition));
            }

            if (taskRepository.count() == 0) {
                taskRepository.saveAll(
                    List.of(
                        new BillableTask("Design registration form", LocalDate.now().plusDays(4), false, BigDecimal.valueOf(90)),
                        new BillableTask("Prepare event microsite", LocalDate.now().plusDays(8), false, BigDecimal.valueOf(85)),
                        new InternalTask("Team retrospective", LocalDate.now().plusDays(2), false)
                    )
                );
            }
        };
    }
}
