package org.codedojo.projetoIA.zero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ClosestToZeroTest {

    @Test
    public void testClosestToZero1() {
        // Given: um array com números negativos, zero e positivos
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, 0, 5, 10};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser 0
        assertEquals(0, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero2() {
        // Given: um array com números negativos e positivos, sem zero
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, 5, 10};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser 5
        assertEquals(5, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero3() {
        // Given: um array com números negativos e positivos, incluindo -1 e 1
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, -1, 1, 10};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser 1
        assertEquals(1, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero4() {
        // Given: um array com números negativos e positivos, sem zero e sem 1
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, -1, 10};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser -1
        assertEquals(-1, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero5() {
        // Given: um array com números negativos e positivos, sem zero e sem 1
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, 10};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser -5
        assertEquals(-5, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero6() {
        // Given: um array com um único número positivo
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {10};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser 10
        assertEquals(10, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero7() {
        // Given: um array com um único número negativo
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser -10
        assertEquals(-10, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero8() {
        // Given: um array com números negativos, zero e positivos, incluindo 1
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, 0, 1, 10};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser 0
        assertEquals(0, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero9() {
        // Given: um array com números negativos e positivos, incluindo 1
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, 1, 10};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser 1
        assertEquals(1, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZero10() {
        // Given: um array com números negativos, zero e positivos, incluindo -1
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, -1, 0, 10};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser 0
        assertEquals(0, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZeroWithNegativeNumbers() {
        // Given: um array com apenas números negativos
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, -3, -1};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser -1
        assertEquals(-1, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZeroWithPositiveNumbers() {
        // Given: um array com apenas números positivos
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {1, 3, 5, 10};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser 1
        assertEquals(1, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZeroWithMixedNumbers() {
        // Given: um array com números negativos, zero e positivos
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {-10, -5, 0, 5, 10};
        // When: chamamos o método closestToZero
        // Then: o resultado deve ser 0
        assertEquals(0, cz.closestToZero(numbers));
    }

    @Test
    public void testClosestToZeroWithEmptyArray() {
        // Given: um array vazio
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = {};
        // When: chamamos o método closestToZero
        // Then: deve lançar IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            cz.closestToZero(numbers);
        });
    }

    @Test
    public void testClosestToZeroWithNullArray() {
        // Given: um array nulo
        ClosestToZero cz = new ClosestToZero();
        int[] numbers = null;
        // When: chamamos o método closestToZero
        // Then: deve lançar NullPointerException
        assertThrows(NullPointerException.class, () -> {
            cz.closestToZero(numbers);
        });
    }
}