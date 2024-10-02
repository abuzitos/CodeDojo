package org.codedojo.projetoIA.montyHall;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MontyHallTest {

    @Test
    public void testRunSimulationSwitching() {
        int switchWins = MontyHall.runSimulation(true);
        assertTrue(switchWins >= 0 && switchWins <= MontyHall.TOTAL_GAMES, 
                   "Switching strategy wins should be between 0 and " + MontyHall.TOTAL_GAMES);
    }

    @Test
    public void testRunSimulationStaying() {
        int stayWins = MontyHall.runSimulation(false);
        assertTrue(stayWins >= 0 && stayWins <= MontyHall.TOTAL_GAMES, 
                   "Staying strategy wins should be between 0 and " + MontyHall.TOTAL_GAMES);
    }

    @Test
    public void testSimulateGameSwitching() {
        boolean result = MontyHall.simulateGame(true);
        assertNotNull(result, "Simulate game with switching should return a boolean value");
    }

    @Test
    public void testSimulateGameStaying() {
        boolean result = MontyHall.simulateGame(false);
        assertNotNull(result, "Simulate game with staying should return a boolean value");
    }
}