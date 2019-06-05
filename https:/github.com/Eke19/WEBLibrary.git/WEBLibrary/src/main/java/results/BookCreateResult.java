package results;

import javax.xml.bind.annotation.XmlRootElement;

import errorHandling.Pair;

@XmlRootElement
public class BookCreateResult extends Result {
	
	private int bookID;

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public BookCreateResult(int errorCode, String errorMessage, int bookID) {
		super(errorCode, errorMessage);
		this.bookID = bookID;
		
	}
	
	public BookCreateResult(Pair<Integer, String> pair, int bookID) {
		//this(pair.getFirst(), pair.getSecond(), bookID);
		super(pair);
		this.bookID = bookID;
	}
	
	public BookCreateResult(Pair<Integer, String> pair) {
		this(pair, 0);
	}
	
	public BookCreateResult() {
		
	}
	
	

}
