package com.twu.refactoring;

public class South extends Direction{
    private static Direction south = new South();

    public static Direction getSouth() {
        return south;
    }

    private South() {
        super('S');
    }

    @Override
    public Direction turnRight(){
        return West.getWest();
    }

    @Override
    public Direction turnLeft() {
        return East.getEast();
    }
}
