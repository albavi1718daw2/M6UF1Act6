import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Books")
class Books {
	
	private Book[] books;
 
	
	public Book[] getBooks() {
		return books;
	}
	
	public void setBooks(Book[] book) {
		this.books = book;
	}
 
}