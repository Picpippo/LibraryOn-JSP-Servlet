package libraryon.model;

public class Book {

	private Long id_book;
	private String title;
	private String author;
	private int quantity;
	private String editor;
	private String position;

	public Book() {
		super();
	}

	public Book(Long id_book, String title, String author, int quantity, String editor, String position) {
		super();
		this.id_book = id_book;
		this.title = title;
		this.author = author;
		this.quantity = quantity;
		this.editor = editor;
		this.position = position;
	}

	public Long getId_book() {
		return id_book;
	}

	public void setId_book(Long id_book) {
		this.id_book = id_book;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
