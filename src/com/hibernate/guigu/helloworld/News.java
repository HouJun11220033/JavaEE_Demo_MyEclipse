package com.hibernate.guigu.helloworld;

public class News {

	private Integer id;
	private String title;
	private String author;

	// private Date date;

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", author=" + author
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public News(String title, String author) {

		this.title = title;
		this.author = author;
		// this.date = (Date);
	}

	public News() {

	}

	public News(Integer id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;

	}

	public void setId(Integer id) {
		this.id = id;
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

}
