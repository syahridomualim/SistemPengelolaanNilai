package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void testCountMean() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        double mean = Util.countMean(data);
        assertEquals(3.0, mean, 0.001);
    }

    @Test
    void testCountMedian() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        double median = Util.countMedian(data);
        assertEquals(3.0, median, 0.001);
    }

    @Test
    void testShowModus() {
        Map<Integer, Integer> frequencyValueMap = Map.of(1, 3, 2, 2, 3, 5, 4, 3);
        int modus = Util.showModus(frequencyValueMap);
        assertEquals(3, modus);
    }

}