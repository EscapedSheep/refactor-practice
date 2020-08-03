package com.twu.refactoring;

public class North extends Direction{

    private static Direction north = new North();

    public static Direction getNorth() {
        return north;
    }

    private North() {
        super('N');
    }

    @Override
    public Direction turnRight() {
        return East.getEast();
    }

    @Override
    public Direction turnLeft() {
        return West.getWest();
    }
}
