package com.example.bookmanagementback;

public class Book {

	private int id;
	private String name;
	private String author;
	private String publisher;
	private String booktype;
	private int numberofpages;
	private int price;

	public Book() {
		
	}

	public Book(String name, String author, String publisher, String booktype, int numberofpages, int price) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.booktype = booktype;
		this.numberofpages = numberofpages;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBooktype() {
		return booktype;
	}

	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}

	public int getNumberofpages() {
		return numberofpages;
	}

	public void setNumberofpages(int numberofpages) {
		this.numberofpages = numberofpages;
	}
	


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", booktype="
				+ booktype + ", numberofpages=" + numberofpages + ", price=" + price + "]";
	}
	
}
