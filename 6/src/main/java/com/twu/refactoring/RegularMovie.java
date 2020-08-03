package com.twu.refactoring;

public class RegularMovie extends Movie{
    private static final double baseCharge = 2;
    private static final double rateOfExtraCharge = 1.5;
    private static final int baseChargeDays = 2;

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int daysRented) {
        double charge = baseCharge;
        if (daysRented > baseChargeDays) {
            charge += (daysRented - baseChargeDays) * rateOfExtraCharge;
        }
        return charge;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
