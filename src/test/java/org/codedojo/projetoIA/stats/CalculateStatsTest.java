package org.codedojo.projetoIA.stats;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CalculateStatsTest {

    @Test
    public void testCalculateStatsNormalCase() {
        List<Integer> numbers = Arrays.asList(6, 9, 15, -2, 92, 11);
        String expected = "minimum value = -2\nmaximum value = 92\nnumber of elements in the sequence = 6\naverage value = 21.833333";
        String result = CalculateStats.calculateStats(numbers);
        assertEquals(expected, result);
    }

    @Test
    public void testCalculateStatsEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculateStats.calculateStats(numbers);
        });
        assertEquals("sequence is empty", exception.getMessage());
    }

    @Test
    public void testCalculateStatsNullList() {
        List<Integer> numbers = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculateStats.calculateStats(numbers);
        });
        assertEquals("sequence is empty", exception.getMessage());
    }

    @Test
    public void testCalculateStatsSingleElement() {
        List<Integer> numbers = Collections.singletonList(42);
        String expected = "minimum value = 42\nmaximum value = 42\nnumber of elements in the sequence = 1\naverage value = 42.000000";
        String result = CalculateStats.calculateStats(numbers);
        assertEquals(expected, result);
    }

    @Test
    public void testCalculateStatsNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-5, -10, -3, -8);
        String expected = "minimum value = -10\nmaximum value = -3\nnumber of elements in the sequence = 4\naverage value = -6.500000";
        String result = CalculateStats.calculateStats(numbers);
        assertEquals(expected, result);
    }
}