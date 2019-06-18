package web;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import dto.BookDTO;
import service.BookService;


@Named
@RequestScoped
public class AddBookBean {
	
	@EJB
	private BookService bookService;
	
	private BookDTO bookDTO;
	
	@PostConstruct
	public void init() {
		bookDTO = new BookDTO();
	}

	public BookDTO getBookDTO() {
		return bookDTO;
	}

	public void setBookDTO(BookDTO bookDTO) {
		this.bookDTO = bookDTO;
	}
	
	public String createBook() {
			bookService.createBook(bookDTO.asBook());
			bookDTO = new BookDTO();
		return "";
	}
	
	

}





	
	