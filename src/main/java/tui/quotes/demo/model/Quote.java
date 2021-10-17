package tui.quotes.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Models the quote entity.
 * 
 * */
@Document("quotes")
public class Quote {

	@Id
	private String id;
	private String quoteAuthor;
	private String quoteText;
	private String quoteGenre;
	
	public Quote(String id, String quoteAuthor, String quoteText, String quoteGenre) {
		super();
		this.id = id;
		this.quoteAuthor = quoteAuthor;
		this.quoteText = quoteText;
		this.quoteGenre = quoteGenre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuoteAuthor() {
		return quoteAuthor;
	}

	public void setQuoteAuthor(String quoteAuthor) {
		this.quoteAuthor = quoteAuthor;
	}

	public String getQuoteText() {
		return quoteText;
	}

	public void setQuoteText(String quoteText) {
		this.quoteText = quoteText;
	}

	public String getQuoteGenre() {
		return quoteGenre;
	}

	public void setQuoteGenre(String quoteGenre) {
		this.quoteGenre = quoteGenre;
	}
	
}