package com.twu.refactoring;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    private int countWithCondition(IntPredicate predicate) {
        IntStream numberStream = Arrays.stream(numbers);
        int count = numberStream.filter(predicate).toArray().length;
        return count;
    }

    public int countEven() {
        IntPredicate evenPredicate = number -> number % 2 == 0;
        return countWithCondition(evenPredicate);
    }

    public int countOdd() {
        IntPredicate oddPredicate = number -> number % 2 == 1;
        return countWithCondition(oddPredicate);
    }

    public int countPositive() {
        IntPredicate positivePredicate = number -> number >= 0;
        return countWithCondition(positivePredicate);
    }

    public int countNegative() {
        IntPredicate negativePredicate = number -> number < 0;
        return countWithCondition(negativePredicate);
    }
}
