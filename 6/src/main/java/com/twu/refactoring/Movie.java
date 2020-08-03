package com.twu.refactoring;

public abstract class Movie {

	private String title;

	public Movie(String title) {
		this.title = title;
	}

	public abstract double getCharge(int daysRented);

	public abstract int getFrequentRenterPoints(int daysRented);

	public String getTitle () {
		return title;
	}
}

