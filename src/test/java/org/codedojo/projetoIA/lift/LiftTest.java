package org.codedojo.projetoIA.lift;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LiftTest {

    @Test
    void testLiftInitialState() {
        Lift lift = new Lift();
        assertEquals(0, lift.getCurrentFloor());
        assertFalse(lift.areDoorsOpen());
    }

    @Test
    void testRequestFloor() {
        Lift lift = new Lift();
        lift.requestFloor(3);
        lift.closeDoors();
        lift.moveToNextFloor();
        assertEquals(3, lift.getCurrentFloor());
        assertTrue(lift.areDoorsOpen());
    }

    @Test
    void testCallLift() {
        Lift lift = new Lift();
        lift.callLift(5, Lift.Direction.UP);
        lift.closeDoors();
        lift.attendCall();
        assertEquals(5, lift.getCurrentFloor());
        assertTrue(lift.areDoorsOpen());
    }

    @Test
    void testDoorsMustBeClosedToMove() {
        Lift lift = new Lift();
        lift.requestFloor(2);
        lift.openDoors();
        lift.moveToNextFloor();
        assertEquals(0, lift.getCurrentFloor()); // Should not move
    }
}
