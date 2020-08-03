package com.twu.refactoring;

public class Receipt {
    private static final int FIXED_CHARGE = 50;
    private static final double PEAK_TIME_MULTIPLIER = 1.2;
    private static final double OFF_PEAK_MULTIPLIER = 1.0;
    private static final int RATE_CHANGE_DISTANCE = 10;
    private static final int PRE_RATE_CHANGE_NON_AC_RATE = 15;
    private static final int POST_RATE_CHANGE_NON_AC_RATE = 12;
    private static final int PRE_RATE_CHANGE_AC_RATE = 20;
    private static final int POST_RATE_CHANGE_AC_RATE = 17;
    private static final double SALES_TAX_RATE = 0.1;

    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    private double getPeakTimeMultiplier() {
        return taxi.isPeakTime() ? PEAK_TIME_MULTIPLIER : OFF_PEAK_MULTIPLIER;
    }

    private int getPreRateChange() {
        return taxi.isAirConditioned() ? PRE_RATE_CHANGE_AC_RATE : PRE_RATE_CHANGE_NON_AC_RATE;
    }

    private int getPostRateChange() {
        return taxi.isAirConditioned() ? POST_RATE_CHANGE_AC_RATE : POST_RATE_CHANGE_NON_AC_RATE;
    }

    private int getPreRateChangeDistance(int totalKms) {
        return Math.min(RATE_CHANGE_DISTANCE, totalKms);
    }

    private int getPostRateChangeDistance(int totalKms) {
        return Math.max(0, totalKms - RATE_CHANGE_DISTANCE);
    }

    private double getTaxiCharges() {
        int totalKms = taxi.getTotalKms();
        int preRateChange = getPreRateChange();
        int postRateChange = getPostRateChange();
        int preRateChangeDistance = getPreRateChangeDistance(totalKms);
        int postRateChangeDistance = getPostRateChangeDistance(totalKms);
        double peakTimeMultiplier = getPeakTimeMultiplier();
        double cost = 0d;
        cost += preRateChangeDistance * preRateChange * peakTimeMultiplier;
        cost += postRateChangeDistance * postRateChange * peakTimeMultiplier;
        return cost;
    }

    private double getCostWithSalesTax(double cost) {
        return cost * (1 + SALES_TAX_RATE);
    }

    public double getTotalCost() {
        double totalCost = 0;
        // fixed charges
        totalCost += FIXED_CHARGE;

        totalCost += getTaxiCharges();

        totalCost = getCostWithSalesTax(totalCost);

        return totalCost;
    }
}
