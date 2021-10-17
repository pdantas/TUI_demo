package tui.quotes.demo.control;

import java.util.List;

import org.springframework.stereotype.Service;

import tui.quotes.demo.model.Quote;
import tui.quotes.demo.repository.QuoteRepository;

@Service
public class QuoteService {

	private final QuoteRepository repo;
	
	public QuoteService(QuoteRepository repo) {
		this.repo = repo;
	}
	
	public Quote findById(String id) {
		return repo.findById(id)
				.orElseThrow(()->new RuntimeException("Can't find quote with id "+id));
	}
	
	public List<Quote> findByAuthor(String author) {
		return repo.findByAuthor(author);
	}
	
	public List<Quote> getAllQuotes() {
		return repo.findAll();
	}
	
	public void createQuote(Quote quote) {
		repo.insert(quote);
	}
}