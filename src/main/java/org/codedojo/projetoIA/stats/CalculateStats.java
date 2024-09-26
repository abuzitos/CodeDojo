package org.codedojo.projetoIA.stats;

import java.util.Arrays;
import java.util.List;

public class CalculateStats {

    public static String calculateStats(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("sequence is empty");
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int count = 0;

        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
            sum += number;
            count++;
        }

        double average = (double) sum / count;

        return String.format("minimum value = %d\nmaximum value = %d\nnumber of elements in the sequence = %d\naverage value = %.6f",
                min, max, count, average);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(6, 9, 15, -2, 92, 11);
        try {
            String stats = calculateStats(numbers);
            System.out.println(stats);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}