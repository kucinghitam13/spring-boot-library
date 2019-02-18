package com.example.sbl.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Book {
	@Id
	private long bookId;

	@NotNull
	private String authorName;
	@NotNull
	private String title;
	@NotNull
	private short publishedYear;
	@NotNull
	private int stock;

	public long getBookId() {
		return bookId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getTitle() {
		return title;
	}

	public short getPublishedYear() {
		return publishedYear;
	}

	public int getStock() {
		return stock;
	}

	public void borrowedOne() {
		this.stock--;
	}

	public void returnedOne() {
		this.stock++;
	}
}
