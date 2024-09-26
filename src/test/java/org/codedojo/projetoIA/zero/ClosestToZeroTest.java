package org.codedojo.projetoIA.zero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ClosestToZeroTest {

    @Test
    public void testClosestToZero1() {
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, 0, 5, 10};
        assertEquals(0, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero2() {
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, 5, 10};
        assertEquals(5, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero3() {
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, -1, 1, 10};
        assertEquals(1, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero4() {
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, -1, 10};
        assertEquals(-1, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero5() {
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, 10};
        assertEquals(-5, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero6() {
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {10};
        assertEquals(10, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero7() {
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10};
        assertEquals(-10, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero8() {
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, 0, 1, 10};
        assertEquals(0, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero9() {
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, 1, 10};
        assertEquals(1, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero10() {
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, -1, 0, 10};
        assertEquals(0, cz.closestToZero(numbers));
    }
}