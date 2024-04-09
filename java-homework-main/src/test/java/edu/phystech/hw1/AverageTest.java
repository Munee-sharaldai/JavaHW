package edu.phystech.hw1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AverageTest {

    private static double average(int... arr) {
        if (arr.length == 0) {
            return 0;
        }
        else {
            double sum = 0;
            for (int a : arr) {
                sum += a;
            }
            return ((double) sum / arr.length);
        }
    }


    @Test
    public void calculateAverage() {
        Assertions.assertEquals(5d, average(5));
        Assertions.assertEquals(4d, average(3, 5));
        Assertions.assertEquals(4d, average(3, 4, 5));

        //        Раскомментировать, эти строчки тоже должны работать.
        Assertions.assertEquals(0, average());
        Assertions.assertEquals(3.5, average(1, 2, 3, 4, 5, 6));
        Assertions.assertEquals(6.5, average(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        Assertions.assertEquals(((double) Integer.MAX_VALUE + 1) / 2, average(1, Integer.MAX_VALUE));
    }
}
