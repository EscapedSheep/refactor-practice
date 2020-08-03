package com.twu.refactoring;

public class NewReleaseMovie extends Movie{
    private static final double rateOfDaysCharge = 3;
    private static final int daysOfNormalPoint = 1;

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * rateOfDaysCharge;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > daysOfNormalPoint ? 2 : 1;
    }
}
