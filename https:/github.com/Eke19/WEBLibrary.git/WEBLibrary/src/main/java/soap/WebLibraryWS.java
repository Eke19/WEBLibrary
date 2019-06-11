package soap;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import domain.Book;
import domain.Category;
import dto.BookDTO;
import errorHandling.LibraryException;
import results.BookCreateResult;
import results.BookResult;
import results.BooksResult;
import results.Result;
import service.BookService;

@Stateless
@WebService
public class WebLibraryWS {
	
	@EJB
	private BookService bookService;
	
	public BookCreateResult createBook(BookDTO bookDTO) {
		
		Book book = bookDTO.asBook();
		
		try {
			int id = bookService.createBook(book);
			return new BookCreateResult(LibraryException.OK, id);
		
		}catch (LibraryException ex){
			
			return new BookCreateResult(ex.getError());
			
		}
	}
		
	
	public Result editBook(int bookId, BookDTO bookDTO) {
		
		try {
			Book book = bookService.editBook(bookId, bookDTO);
			return new Result(LibraryException.OK);
			
		}catch(LibraryException ex) {
			
			return new Result(ex.getError());
				
		}
	}
	
	
	
	public  BookResult getBook(int bookId) {
		
		try {
			Book book = bookService.getBook(bookId);
			BookDTO bookDTO = book.asBookDTO();
			return new BookResult(LibraryException.OK, bookDTO);
			
		}catch(LibraryException ex) {
			
			return new BookResult(ex.getError());
			
		}	
	}
	
	
	public BooksResult getBooks() {
		
		try {
			return new BooksResult(LibraryException.OK, bookService.getBooks());
			
		}catch(LibraryException ex) {
			return new BooksResult(ex.getError(), null);
		}
		
	}
	
	
	public Result deleteBook(int bookId) {
		
		try {
			bookService.removeBook(bookId);
			return new Result(LibraryException.OK);
			
		}catch(LibraryException ex) {
			return new Result(ex.getError());
		}
	}
	
	
	public BooksResult searchBooks(String title, String author, String isbn, Category category) {
		
		BookDTO bookDTO = new BookDTO();
		bookDTO.setTitle(title);
		bookDTO.setAuthor(author);
		bookDTO.setIsbn(isbn);
		bookDTO.setCategory(category);
		
		return find(bookDTO);
		
	}
	
	
	public BooksResult find (BookDTO bookDTO) {
		try {
			List<BookDTO> books = bookService.find(bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getIsbn(), bookDTO.getCategory());
			return new BooksResult(LibraryException.OK, books);
		}catch(LibraryException ex) {
			
			return new BooksResult(ex.getError(), null);
		}
			
	}
	
}
	


