package web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import dto.BookDTO;
import service.BookService;


@Named
@RequestScoped
public class ListBookBean {
	
	//@Inject
		@EJB
		private BookService bookService;
		
		private List<BookDTO> books;
		
		@PostConstruct
		public void init() {
			books = bookService.getFullBooks();
		}

		public List<BookDTO> getBooks() {
			return books;
		}

		public void setBooks(List<BookDTO> books) {
			this.books = books;
		}
		
		

	}



