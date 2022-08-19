package com.fdmgroup.bookstore.model;

public class EBook extends Book{

	private int timeLengthSeconds;

	public int getTimeLengthSeconds() {
		return timeLengthSeconds;
	}

	public void setTimeLengthSeconds(int timeLengthSeconds) {
		this.timeLengthSeconds = timeLengthSeconds;
	}

	public EBook(int timeLengthSeconds) {
		super();
		this.timeLengthSeconds = timeLengthSeconds;
	}

	public EBook() {
		super();
	}
	
}
