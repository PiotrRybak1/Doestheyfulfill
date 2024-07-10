package pl.coderslab.doestheyfulfill.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.coderslab.doestheyfulfill.domain.PromiseStatus;
import pl.coderslab.doestheyfulfill.repository.PromiseStatusRepository;

@Configuration
public class DatabaseInitializer {

    @Bean
    CommandLineRunner initDatabase(PromiseStatusRepository repository) {
        return args -> {
            repository.save(new PromiseStatus(PromiseStatus.Name.PROMISE_MADE));
            repository.save(new PromiseStatus(PromiseStatus.Name.IN_PROGRESS));
            repository.save(new PromiseStatus(PromiseStatus.Name.COMPLETED));
            repository.save(new PromiseStatus(PromiseStatus.Name.NOT_IMPLEMENTED));
        };
    }
}

