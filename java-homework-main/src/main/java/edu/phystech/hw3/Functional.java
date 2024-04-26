package edu.phystech.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Functional {

    public static <T, R> List<R> map(List<T> collection, Function<T, R> function) {
        List<R> result = new ArrayList<>(collection.size());
        for (T element : collection) {
            R mappedElement = function.apply(element);
            result.add(mappedElement);
        }
        return result;
    }

    public static <T, R> T reduce(List<T> collection, BinaryOperator<T> operator, T identity) {
        if (collection.isEmpty()) {
            return identity;
        }

        T accumulator = identity;
        for (T element : collection) {
            accumulator = operator.apply(accumulator, element);
        }
        return accumulator;
    }
}




