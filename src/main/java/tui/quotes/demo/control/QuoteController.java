package tui.quotes.demo.control;

import org.springframework.web.bind.annotation.RestController;

import tui.quotes.demo.model.Quote;

import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/quotes")
public class QuoteController {
	
	private static final Log log = LogFactory.getLog(QuoteController.class);
	private final QuoteService service;
	
	public QuoteController(QuoteService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Quote> getQuoteById(@PathVariable String id) {
    	log.info(String.format("Searching for quote with id %s",id));
    	Instant start = Instant.now();
    	try {
    		ResponseEntity<Quote> response = ResponseEntity.ok(service.findById(id));
    		Instant end = Instant.now();
    		Duration duration = Duration.between(start, end);
    		log.info(String.format("1 quote found in %d miliseconds.", (duration.getNano()/1000000)));
    		return response;
    	} catch (Exception e) {
    		log.info("Quote not found.");
    		return new ResponseEntity<Quote>(HttpStatus.NOT_FOUND);
    	}
	}
	
	@GetMapping
	public ResponseEntity<List<Quote>> getQuoteByAuthor(@RequestParam(required = false)String author) {	    
	    List<Quote> quotes = null;
		//if author parameter is present, filter by it
	    if(author != null) {
	    	log.info(String.format("Searching for quotes by author %s.",author));
	    	Instant start = Instant.now();
	    	quotes = this.service.findByAuthor(author);
    		Instant end = Instant.now();
    		Duration duration = Duration.between(start, end);
	    	log.info(String.format("Found %d quotes by %s in %d miliseconds.", 
	    			quotes.size(), author, (duration.getNano()/1000000)));
	    }
	    //in the absence of filters, return all quotes
	    else {
			log.info("No filter provided in the request, retrieving all quotes.");
	    	Instant start = Instant.now();
			quotes = this.service.getAllQuotes();
    		Instant end = Instant.now();
    		Duration duration = Duration.between(start, end);
	    	log.info(String.format("Found %d quotes total in %d miliseconds.",
	    			quotes.size(), (duration.getNano()/1000000)));
	    }
	    return ResponseEntity.ok(quotes);
	}
	
	@PostMapping
	public ResponseEntity createQuote(@RequestBody Quote quote) {
		this.service.createQuote(quote);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}