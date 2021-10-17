package tui.quotes.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class QuotesDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(QuotesDemoApplication.class, args);
	}

}