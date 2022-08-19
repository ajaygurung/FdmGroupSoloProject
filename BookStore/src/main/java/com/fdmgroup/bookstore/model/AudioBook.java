package com.fdmgroup.bookstore.model;

public class AudioBook extends Book{

	private double sizeMegaBytes;

	public double getSizeMegaBytes() {
		return sizeMegaBytes;
	}

	public void setSizeMegaBytes(double sizeMegaBytes) {
		this.sizeMegaBytes = sizeMegaBytes;
	}

	public AudioBook(double sizeMegaBytes) {
		super();
		this.sizeMegaBytes = sizeMegaBytes;
	}

	public AudioBook() {
		super();
	}
	
	
}
