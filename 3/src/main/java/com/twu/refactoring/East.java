package com.twu.refactoring;

public class East extends Direction{
    private static Direction east = new East();

    public static Direction getEast() {
        return east;
    }

    private East() {
        super('E');
    }

    @Override
    public Direction turnRight(){
        return North.getNorth();
    }

    @Override
    public Direction turnLeft() {
        return North.getNorth();
    }
}
