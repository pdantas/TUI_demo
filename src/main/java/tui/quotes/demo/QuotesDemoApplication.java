package tui.quotes.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/*
 * Initial class for the TUI Quotes Demo.
 * This application exposes a simple API that allows for parsing a quotes database.
 * See class QuoteController for more details on the API.
 * 
 * @author Pedro Ivo Dantas
 * 
 * */
@SpringBootApplication
@EnableMongoRepositories
public class QuotesDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(QuotesDemoApplication.class, args);
	}

}