package com.twu.refactoring;

public class West extends Direction{

    private static Direction west = new West();

    public static Direction getWest(){
        return west;
    }

    private West(){
        super('W');
    }

    @Override
    public Direction turnRight(){
        return South.getSouth();
    }

    @Override
    public Direction turnLeft() {
        return South.getSouth();
    }

}
