package tui.quotes.demo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import tui.quotes.demo.model.Quote;

/*
 * We're using MongoDB as the repository. 
 * Persistance logic is injected by Spring.
 * Connection details are defined in the application.properties file.
 * 
 * */
public interface QuoteRepository extends MongoRepository<Quote, String> {
	
	@Query("{ 'quoteAuthor' : ?0 }")
	List<Quote> findByAuthor(String author);
	
}