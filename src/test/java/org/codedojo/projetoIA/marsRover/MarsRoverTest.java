package org.codedojo.projetoIA.marsRover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarsRoverTest {
    private Rover rover;

    @BeforeEach
    public void setUp() {
        rover = new Rover(1);
    }

    @Test
    public void testInitialPosition() {
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals('N', rover.getDirection());
    }

    @Test
    public void testMoveNorth() {
        rover.move('N', 3);
        assertEquals(0, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals('N', rover.getDirection());
    }

    @Test
    public void testMoveSouth() {
        rover.move('S', 2);
        assertEquals(0, rover.getX());
        assertEquals(-2, rover.getY());
        assertEquals('S', rover.getDirection());
    }

    @Test
    public void testMoveEast() {
        rover.move('L', 5);
        assertEquals(5, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals('L', rover.getDirection());
    }

    @Test
    public void testMoveWest() {
        rover.move('O', 4);
        assertEquals(-4, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals('O', rover.getDirection());
    }
}