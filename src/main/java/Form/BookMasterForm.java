package Form;

import javax.validation.constraints.NotNull;

public class BookMasterForm{
	@NotNull
	private String bookId;
	@NotNull
	private String bookTitle;
	@NotNull
	private String authorName;
	@NotNull
	private String publisher;
	@NotNull
	private Integer publicationYear;
	@NotNull
	private Integer publicationMonth;
	@NotNull
	private Integer publicationDate;

	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTittle) {
		this.bookTitle = bookTittle;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public Integer getPublicationMonth() {
		return publicationMonth;
	}
	public void setPublicationMonth(Integer publicationMonth) {
		this.publicationMonth = publicationMonth;
	}
	public Integer getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Integer publicationDate) {
		this.publicationDate = publicationDate;
	}
	
}