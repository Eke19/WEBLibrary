package results;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import dto.BookDTO;
import errorHandling.Pair;

@XmlRootElement
public class BooksResult extends Result{
	
	private List<BookDTO> books;
	
	public BooksResult() {
		
	}
	
	public BooksResult(int errorCode, String errorMessage, List<BookDTO> books) {
		super(errorCode, errorMessage);
		this.books = books;
	}
	
	public BooksResult(Pair<Integer, String> pair, List<BookDTO> books) {
		this(pair.getFirst(), pair.getSecond(), books);
	}

	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
	
	

}

